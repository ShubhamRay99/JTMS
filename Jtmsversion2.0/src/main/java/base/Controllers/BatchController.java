package base.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import base.model.Batch;
import base.model.Subject;
import base.repository.BatchRepository;
import base.repository.SubjectRepository;

@Controller
public class BatchController {
	
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	BatchRepository batchRepository;
	
	private Subject matchedSubject;
	
	
	/*Subject Added*/
	@PostMapping("/addedSubject")
	public String addedSubject(@ModelAttribute Subject subject) {
		
		Subject savedsubject = subjectRepository.save(subject);
		
		if(savedsubject!=null) {
			return "redirect:/batch";
		}else {
			return "404";
		}
	}
	
	@RequestMapping("/batch")
	public String batch(Model model) {
		
		/* select A subject */
		List<Subject> allSubjectInfo = (List<Subject>) subjectRepository.findAll();
		model.addAttribute("subjects",allSubjectInfo);
		
		/* batch informations for representation in table */
		List<Batch> allBatchInfo = (List<Batch>) batchRepository.findAll();
		model.addAttribute("allBatch",allBatchInfo);
		
		return "batch";
	}
	
	@PostMapping("/addedBatch")
	public String addedBatch(@ModelAttribute Batch batch) throws ParseException {
		
		
		Optional<Subject> subject = subjectRepository.findById(batch.getSubject_code());
		subject.ifPresent(data -> {
			 matchedSubject = data;
		});
		
		batch.setBatchName(generateBatchName(matchedSubject.getName(), batch.getBatch_starting_date()));
		batch.setArrival_timing(_12HourFormat(batch.getArrival_timing()));
		batch.setDeparture_timing(_12HourFormat(batch.getDeparture_timing()));
		
		Batch batchSaved = batchRepository.save(batch);
		
		if(batchSaved!=null) {
			return "redirect:/batch";
		}else {
			return "404";
		}
		
	}

			/* convert 24 hour format to 12 hour format */
	private String _12HourFormat(String arrival_timing) throws ParseException {
		String _24HourTime =arrival_timing;
        SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
        SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
        Date _24HourDt = _24HourSDF.parse(_24HourTime);
		return _12HourSDF.format(_24HourDt);
	}

	/* generate Batch name Automatically */
	private String generateBatchName(String subject, String batch_starting_date) {
		String Course = subject;
		String date=batch_starting_date;
		
		String month = null;
		
		switch (date.substring(5, 7)) {
			case "01":
				month = "Jan";
				break;
			case "02":
				month = "Fev";
				break;
			case "03":
				month = "March";
				break;
			case "04":
				month = "Apl";
				break;
			case "05":
				month = "May";
				break;
			case "06":
				month = "June";
				break;
			case "07":
				month = "July";
				break;
			case "08":
				month = "Aug";
				break;
			case "09":
				month = "Sep";
				break;
			case "10":
				month = "Oct";
				break;
			case "11":
				month = "Nov";
				break;
			case "12":
				month = "Dec";
				break;
		}
		String batchName = Course + " " + date.substring(8,10) + month + date.substring(0, 4);
		return batchName;
	}
}
