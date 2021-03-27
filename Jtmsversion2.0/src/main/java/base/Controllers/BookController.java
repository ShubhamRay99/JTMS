package base.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import base.model.Book;
import base.model.JtianBookIssue;
import base.model.NonJtianBookIssued;
import base.model.Student_personal_info;
import base.repository.BookRepository;
import base.repository.JtianBookIssueRepository;
import base.repository.NonJtianBookIssuedRepository;
import base.repository.StudentCourseInfoRepository;
import base.repository.Student_personal_infoRepository;

@Controller
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	NonJtianBookIssuedRepository nonJtianBookIssuedRepository;

	@Autowired
	Student_personal_infoRepository student_personal_infoRepository;

	@Autowired
	StudentCourseInfoRepository studentCourseInfoRepository;

	@Autowired
	JtianBookIssueRepository jtianBookIssueRepository;

	@RequestMapping(value = { "/book", "/addedBook" })
	public String book(Model model) {
		List<Book> findAll = (List<Book>) bookRepository.findAll();
		model.addAttribute("allData", findAll);
		return "book";
	}

	@PostMapping("/addedBook")
	public String bookAdded(@ModelAttribute Book book) {
		Book save = bookRepository.save(book);
		if (save != null) {
			return "redirect:/book";
		} else {
			return null;
		}
	}

	@PostMapping("/issueBook")
	public String issueBook(@ModelAttribute NonJtianBookIssued issued) {
		try {
			// check he/she is a jtian or not
			Student_personal_info student = student_personal_infoRepository.findByNameAndEmail(issued.getName(),
					issued.getEmail());
			if (student != null) {
				List<JtianBookIssue> bookInfo = jtianBookIssueRepository.findByStudentId(student.getPersonal_id());

				/*
				 * rule: A jtian after opting for a subject, can recieve a book of that
				 * particular subject for free. And if he/she wants to purchase a book that
				 * which does comes under his/her opted course then, he/she had to pay a certain
				 * amount as like as a non-jtian does.
				 */
				Boolean bookStatus = false;
				for (JtianBookIssue jtianBookIssue : bookInfo) { // if a jtian already have this book
																	// he/she can't purchase it again.
					if (issued.getBookName().equals(jtianBookIssue.getBookName())) {
						bookStatus = true;
						return "404"; // modify it later
					}
				}
				/*
				 * and he/she doesn't have that particular book then issue that to him/her.
				 */
				if (!bookStatus) {

					JtianBookIssue bookissueSave = new JtianBookIssue();
					bookissueSave.setId(issued.getId());
					bookissueSave.setBookName(issued.getBookName());
					bookissueSave.setBookPrice(issued.getPrice());
					bookissueSave.setStudentId(student.getPersonal_id());
					jtianBookIssueRepository.save(bookissueSave);

				}

			} else {
				NonJtianBookIssued savedIssued = nonJtianBookIssuedRepository.save(issued);
			}

		} catch (Exception e) {
			return "404";
		}

		return "redirect:/book";
	}

	@PostMapping("/book/bookprice/{bid}")
	public ResponseEntity<?> bookPrice(@PathVariable String bid) {
		try {
			int id = Integer.parseInt(bid);
			if (bookRepository.findById(id).isPresent()) {
				Book book = bookRepository.findById(id).get();
				return ResponseEntity.status(200).body(book.getBook_price());
			} else {
				return ResponseEntity.status(400).body("Book Not Found");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("not Found");
		}

	}
}
