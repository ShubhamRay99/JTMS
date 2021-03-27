package base.Controllers;

import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import base.model.Admin;
import base.model.ForgetPasswordLink;
import base.repository.AdminRepository;
import base.repository.ForgetPasswordLinkRepository;

@Controller
public class AdminRegistrationController {
	
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	private JavaMailSender sender;
	@Autowired
	ForgetPasswordLinkRepository forgetPasswordLinkRepository;
	
									/* admin Registration page */
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/registering")
	public String registering(@ModelAttribute Admin admin) {
		Admin saved = adminRepo.save(admin);
		if(saved!=null) {
			return "login";
		}else {
			System.out.println("Opps..");
			return null;
		}
	}
									/* admin login page */
	@RequestMapping(value= {"/","/login"})
	public String login() {
		return "login";
	}
	@PostMapping("/logging")
	public String Logging(@ModelAttribute Admin admin) {
		
			Admin adminObj = adminRepo.findByNameAndPassword(admin.getName(), admin.getPassword());
			if(adminObj != null) {
				return "dashboard";			
			}else {
				System.out.println("Opps..");
				return null;
			}
	}
	
					/* forget	password */
	@RequestMapping("/forgetPassword")
	public String forgetpassword() {
		return "forgetpassword";
	}
	private String adminEmail=null;
	private String adminName=null;
	@PostMapping("forgetpassword/mailsent")
	public String mailsent(@RequestParam String name,@RequestParam String email,ModelMap model,HttpServletRequest request) {
		adminEmail=email;
		adminName=name;
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		try {
			String link = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/updatepassword";
			helper.setTo(email);
			helper.setSubject("Reset Password");
			helper.setText("<html>To set a password <a href='"+link+"'>click here</a></html>",true);
			sender.send(msg);
			
			/* save a date to check validity */
			ForgetPasswordLink linkCreation = new ForgetPasswordLink();
			linkCreation.setEmail(email);
			forgetPasswordLinkRepository.save(linkCreation);

			model.addAttribute("message","Check Your Mail to Reset Your Password");
			
			System.out.println("mail send successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mail couldn't send");
		}
		
		return "redirect:/login";
	}

							/* Update Password */
	@RequestMapping("/updatepassword")
	public String updatepassword() {
		/* check link validity */
		
		ForgetPasswordLink admin = forgetPasswordLinkRepository.findByEmail(adminEmail);
		Date createdDate = admin.getCreateDateTime();
		Calendar calender = Calendar.getInstance();
		calender.setTime(createdDate);
		calender.add(Calendar.MINUTE, 2);
		Date newDate =  calender.getTime();
		
		if(new Date().before(newDate)) {
			ForgetPasswordLink user = forgetPasswordLinkRepository.findByEmail(adminEmail);
			forgetPasswordLinkRepository.delete(user);
			return "updatepassword";
		}
		else 
		{
			System.out.println("Opps");
			
			return "batch";
		}
		

	}
	
	@PostMapping("/updatingpassword")
	public String updatingpassword(@RequestParam String password,@RequestParam String confirmpassword) {
		
		Admin admin = adminRepo.findByEmailAndName(adminEmail,adminName);
		if(password.equals(confirmpassword)) {
			admin.setPassword(password);
			adminRepo.save(admin);
		}
		
		return "login";
	}
	
}
