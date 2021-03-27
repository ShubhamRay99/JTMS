package base.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import base.model.Batch;
import base.model.Enquiry;
import base.model.Parential_information;
import base.model.StudentCourseInfo;
import base.model.Student_personal_info;
import base.model.Subject;
import base.repository.BatchRepository;
import base.repository.EnquiryRepository;
import base.repository.Parential_informationRepository;
import base.repository.StudentCourseInfoRepository;
import base.repository.Student_personal_infoRepository;
import base.repository.SubjectRepository;

@Controller
public class StudentRegistationController {

	@Autowired
	Student_personal_infoRepository student_personal_infoRepository;

	@Autowired
	Parential_informationRepository parential_informationRepository;

	@Autowired
	StudentCourseInfoRepository studentCourseInfoRepository;

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	BatchRepository batchRepository;

	private Student_personal_info jtianStudent;

	@RequestMapping("/student")
	public String student() {
		return "student";
	}

	/*
	 * checks the student is a jtian or non-jtian or has enquired before!
	 */

	// searched Name And Email objects
	private String name, email;

	@PostMapping("/showStatus")
	public String showStatus(@RequestParam String searchedName, @RequestParam String searchedEmail) {

		String status = null;

		name = searchedName;
		email = searchedEmail;

		Enquiry enquiry = enquiryRepository.findByNameAndEmail(name, email);
		Student_personal_info student = student_personal_infoRepository.findByNameAndEmail(name, email);

		if (student != null) {
			status = "Jtian";

		} else if (enquiry != null) {
			status = "Enquired";
		}

		if (status == "Jtian") {
			return "redirect:/showStatusForJtian";
		} else if (status == "Enquired") {
			return "redirect:/showStatusForEnquired";
		} else {
			return "redirect:/showStatusForNonJtian";
		}

	}

//------------------------------------------------------------------------------------------------------------//

	/* Jtian Registration */

	@RequestMapping(value = { "/showStatusForJtian" })
	public String showStatusForJtian(Model model) {

		Student_personal_info student = student_personal_infoRepository.findByNameAndEmail(name, email);
		Parential_information parent = parential_informationRepository.findByStudentId(student.getPersonal_id());
		List<StudentCourseInfo> coursesList = studentCourseInfoRepository
				.findListOfRequiredCourses(student.getPersonal_id());
		List<Subject> allSubjectsList = (List<Subject>) subjectRepository.findAll();

		model.addAttribute("student", student);
		model.addAttribute("parent", parent);
		model.addAttribute("OptedBatch", coursesList);
		model.addAttribute("allSubjects", allSubjectsList);

		return "showStatusForJtian";
	}

//	----------------------------------------------------------Edit jtian personal details------------------------
	@PostMapping("/JtianPersonalDetails/{id}")
	public String JtianPersonalDetails(@PathVariable("id") Long id,
			@ModelAttribute Student_personal_info changedStudent, @ModelAttribute Parential_information changedParent) {

		Optional<Student_personal_info> student = student_personal_infoRepository.findById(id);
		student.ifPresent(savedStudent -> {
			jtianStudent = savedStudent;
		});

		jtianStudent.setName(changedStudent.getName());
		jtianStudent.setEmail(changedStudent.getEmail());
		jtianStudent.setPhone(changedStudent.getPhone());
		jtianStudent.setBranch(changedStudent.getBranch());
		jtianStudent.setCollege(changedStudent.getCollege());
		jtianStudent.setYop(changedStudent.getYop());

		jtianStudent = student_personal_infoRepository.save(jtianStudent);

		Parential_information parent = parential_informationRepository.findByStudentId(id);
		parent.setAddress(changedParent.getAddress());
		parent.setGuardian_name(changedParent.getGuardian_name());
		parent.setGuardian_phone(changedParent.getGuardian_phone());
		parent.setPincode(changedParent.getPincode());
		parential_informationRepository.save(parent);

		return "redirect:/showStatusForJtian";
	}

//	----------------------------------jtian course Details--------------------------------------------------//

	@PostMapping("/editBatch/{student_id}/{batchName}")
	public String JtiancourseDetails(@PathVariable("student_id") Long student_id,
			@PathVariable("batchName") String batchName, @RequestParam Integer payed) {
		
		
		StudentCourseInfo course = studentCourseInfoRepository.findRequiredCourse(student_id, batchName);
//		get the actual course amount
		Batch batch = batchRepository.findByBatchName(batchName);
		Optional<Subject> subject = subjectRepository.findById(batch.getSubject_code());
		
		Integer alreadyPayed = 0, dueAmount = 0;
		alreadyPayed = course.getPayed();
		course.setPayed(alreadyPayed + payed);
		dueAmount = course.getDue() - payed;

		if(dueAmount > subject.get().getFee()) {
			return "404";
		}else {
			course.setDue(dueAmount);
		}
		
		
		studentCourseInfoRepository.save(course);

		return "redirect:/showStatusForJtian";
	}

//----------------------------------new course details--------------------------------------------------------//
	@PostMapping("/JtianCourseDetails/viewSubjectFee/{id}")
	public ResponseEntity<?> viewFeeForJtian(@PathVariable("id") String id) {
		try {
			Long subject_id = Long.parseLong(id);

			if (subjectRepository.findById(subject_id).isPresent()) {
				Subject subject = subjectRepository.findById(subject_id).get();

				return ResponseEntity.status(200).body(subject.getFee());
			} else {
				return ResponseEntity.status(400).body(0);
			}
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Nothing found");
		}
	}

	@PostMapping("/JtianCourseDetails/viewBatches/{id}")
	public ResponseEntity<?> batchListForJtian(@PathVariable("id") String id, Model model) {
		try {
			Long subject_id = Long.parseLong(id);

			List<Batch> batch = batchRepository.findRequiredBatch(subject_id);

			return ResponseEntity.status(200).body(batch);
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Nothing found");
		}
	}

	@PostMapping("/checkOutSomeNewCourses/{studentId}")
	public String addNewCourse(@PathVariable("studentId") Long id, @ModelAttribute StudentCourseInfo optedCourse) {

		Optional<Student_personal_info> foundStudent = student_personal_infoRepository.findById(id);

		StudentCourseInfo courseOpted = new StudentCourseInfo();
		courseOpted.setStudentid(foundStudent.get().getPersonal_id());
		courseOpted.setCid(optedCourse.getCid());
		courseOpted.setSubjectCode(optedCourse.getSubjectCode());
		courseOpted.setBatchName(optedCourse.getBatchName());
		courseOpted.setPayed(optedCourse.getPayed());
		// calculate due amount
		Optional<Subject> optedSubject = subjectRepository.findById(optedCourse.getSubjectCode());
		Integer courseFee = optedSubject.get().getFee();
		Integer payedAmount = optedCourse.getPayed();
		Integer due = courseFee - payedAmount;
		courseOpted.setDue(due);
		courseOpted.setCertificate(false);

		studentCourseInfoRepository.save(courseOpted);

		return "redirect:/showStatusForJtian";
	}
//----------------------------------------------------delete jtian details-----------------------------------------
	@RequestMapping("/delete/{studentId}/{parentId}")
	public String delete(@PathVariable("studentId") Long studentId,@PathVariable("parentId") Long parentId) {
		
		student_personal_infoRepository.deleteById(studentId);
		parential_informationRepository.deleteById(parentId);
//		get, all the list of courses
		List<StudentCourseInfo> optedCourses = studentCourseInfoRepository.findListOfRequiredCourses(studentId);
//		delete the courses serially
		int count = optedCourses.size();
		for (int i = 0; i < count; i++) {
//			get the courseId of each course to a variable
			Long tempCourseId = optedCourses.get(i).getCid();
			
			studentCourseInfoRepository.deleteByCidAndStudentIdNative(tempCourseId,studentId);
		}
		return "redirect:/student";
	}
	
	
	
//	---------------------------------------------/* Enquired Student Registration */-------------------------------

	@RequestMapping("/showStatusForEnquired")
	public String showStatusForEnquired(Model model) {
		Enquiry enquiry = enquiryRepository.findByNameAndEmail(name, email);
		model.addAttribute("student", enquiry);
		return "showStatusForEnquired";
	}

	@PostMapping("/EnquiredRegistrationDetails")
	public String enquiredRegistrationDetails(@ModelAttribute Student_personal_info changedStudent,
			@ModelAttribute Parential_information changedParent) {

		Student_personal_info student = student_personal_infoRepository.save(changedStudent);
		changedParent.setStudentId(student.getPersonal_id());
		Parential_information parent = parential_informationRepository.save(changedParent);

		/*
		 * if a student is registering for the first time and has already enquired
		 * before
		 */
		/* delete its informations from enquiry table */
		Enquiry enquiry = enquiryRepository.findByNameAndEmail(student.getName(), student.getEmail());
		enquiryRepository.deleteById(enquiry.getId());
		return "redirect:/StudentCourseDetails";
	}

	/* Non Jtian Registration */

	@RequestMapping("/showStatusForNonJtian")
	public String showStatusForNonJtian() {
		return "showStatusForNonJtian";
	}

	private Student_personal_info nonjtian;

	@PostMapping("/nonJtianPersonalDetails")
	public String nonJtianPersonalDetails(@ModelAttribute Student_personal_info changedStudent,
			@ModelAttribute Parential_information changedParent, Model model) {

		nonjtian = student_personal_infoRepository.save(changedStudent);
		changedParent.setStudentId(nonjtian.getPersonal_id());
		parential_informationRepository.save(changedParent);

		return "redirect:/StudentCourseDetails";
	}

	/* Non-jtian & enquired Students course registration */

	@RequestMapping("/StudentCourseDetails")
	public String StudentCourseDetails(Model model) {

		List<Subject> allSubjects = (List<Subject>) subjectRepository.findAll();
		model.addAttribute("AllSubjects", allSubjects);

		return "StudentCourseDetails";
	}

	@PostMapping("/StudentCourseDetails/viewSubjectFee/{id}")
	public ResponseEntity<?> viewFee(@PathVariable("id") String id) {
		try {
			Long subject_id = Long.parseLong(id);

			if (subjectRepository.findById(subject_id).isPresent()) {
				Subject subject = subjectRepository.findById(subject_id).get();

				return ResponseEntity.status(200).body(subject.getFee());
			} else {
				return ResponseEntity.status(400).body(0);
			}
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Nothing found");
		}
	}

	@PostMapping("/StudentCourseDetails/viewBatches/{id}")
	public ResponseEntity<?> batchList(@PathVariable("id") String id, Model model) {
		try {
			Long subject_id = Long.parseLong(id);

			List<Batch> batch = batchRepository.findRequiredBatch(subject_id);

			return ResponseEntity.status(200).body(batch);
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Nothing found");
		}
	}

	@PostMapping("/makeSelectBatches") // store Opted batches
	public String makeSelectBatches(@ModelAttribute StudentCourseInfo optedCourse) {
		Student_personal_info foundStudent = student_personal_infoRepository.findByNameAndEmail(name, email);

		StudentCourseInfo courseOpted = new StudentCourseInfo();
		courseOpted.setStudentid(foundStudent.getPersonal_id());
		courseOpted.setCid(optedCourse.getCid());
		courseOpted.setSubjectCode(optedCourse.getSubjectCode());
		courseOpted.setBatchName(optedCourse.getBatchName());
		courseOpted.setPayed(optedCourse.getPayed());
		// calculate due amount
		Optional<Subject> optedSubject = subjectRepository.findById(optedCourse.getSubjectCode());
		Integer courseFee = optedSubject.get().getFee();
		Integer payedAmount = optedCourse.getPayed();
		Integer due = courseFee - payedAmount;
		courseOpted.setDue(due);
		courseOpted.setCertificate(false);

		studentCourseInfoRepository.save(courseOpted);
		return "student";
	}

}
