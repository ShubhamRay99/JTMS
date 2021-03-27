package base.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import base.model.Student_personal_info;
import base.repository.Student_personal_infoRepository;

@Controller
public class PlacementController {

	@Autowired
	Student_personal_infoRepository student_personal_infoRepository;
	
	@RequestMapping("/placement")
	public String placement(Model model) {
		
//		send all the student's records
		List<Student_personal_info> allStudents = (List<Student_personal_info>) student_personal_infoRepository.findAll();
		model.addAttribute("allStudents",allStudents);
		
		
		return "placement";
	}
	
}
