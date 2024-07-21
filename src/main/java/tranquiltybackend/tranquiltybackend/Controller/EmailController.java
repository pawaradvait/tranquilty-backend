package tranquiltybackend.tranquiltybackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tranquiltybackend.tranquiltybackend.Entity.EmailRequest;
import tranquiltybackend.tranquiltybackend.Service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	
	@Autowired
	
	private EmailService emailService;
	
	@PostMapping("/")
	public String sendEmail(@RequestBody EmailRequest emailrequest) {
		
		this.emailService.sendEmail(emailrequest.getMessage(), emailrequest.getSubject(), emailrequest.getTo());
		return "done";
	}
}
