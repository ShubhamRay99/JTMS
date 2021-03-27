package base.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import base.model.Enquiry;
import base.model.Subject;
import base.repository.EnquiryRepository;
import base.repository.SubjectRepository;

@Controller
public class EnquiryController {

	@Autowired
	EnquiryRepository enquiryRepo;
	@Autowired
	SubjectRepository subjectRepo;
	
	
	@RequestMapping("/enquiry")
	public String enquiry(Model model) {
		
		List<Subject> subject = (List<Subject>) subjectRepo.findAll();
		model.addAttribute("subjects" ,subject);
		
		return "enquiry";
	}
	
	@PostMapping("/addedEnquiry")
	public String addEnquiry(@ModelAttribute Enquiry enquiry) {
		
		Enquiry enquirySaved = enquiryRepo.save(enquiry);
		
		if(enquirySaved!=null) {
			return "redirect:/enquiry";
		}else {
			return "404";
		}
	}
	
}
