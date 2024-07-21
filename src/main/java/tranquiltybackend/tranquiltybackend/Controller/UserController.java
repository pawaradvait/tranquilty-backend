package tranquiltybackend.tranquiltybackend.Controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import tranquiltybackend.tranquiltybackend.Entity.Forgotpassword;
import tranquiltybackend.tranquiltybackend.Entity.PasswordChange;
import tranquiltybackend.tranquiltybackend.Entity.Role;
import tranquiltybackend.tranquiltybackend.Entity.User;
import tranquiltybackend.tranquiltybackend.Entity.UserRoles;
import tranquiltybackend.tranquiltybackend.Repo.ForgetPasswrodRepo;
import tranquiltybackend.tranquiltybackend.Repo.UserRepo;
import tranquiltybackend.tranquiltybackend.Service.EmailService;
import tranquiltybackend.tranquiltybackend.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private ForgetPasswrodRepo fprepo;
	
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/")
	public ResponseEntity<?> addUser(@RequestParam("user") String userString,
			@RequestPart("file") MultipartFile file	
) throws Exception{
		
		User user = mapper.readValue(userString, User.class);
		
		
		Role role = new Role();
		role.setRoleId(1L);
		role.setRoleName("normal");
		
		UserRoles userrole = new UserRoles();
		userrole.setRoles(role);
		userrole.setUser(user);
		
		
		
		Set<UserRoles> userroles = new HashSet<>();
		
		
		
		User tosave = User.builder().firstName(user.getFirstName()).lastName(user.getLastName()).email(user.getEmail()).password(user.getPassword()).username(user.getUsername())
				.phonenos(user.getPhonenos()).photoUser(file.getBytes()).build();
		
		
	userroles.add(userrole);
	tosave.setEnable(true);
	
	tosave.setPassword( passwordEncoder.encode(user.getPassword()));
	return ResponseEntity.ok(this.userService.addUser(tosave,userroles));
		
	}

	
	@GetMapping("/email/{username}")
	public ResponseEntity<?> checkEmail(@PathVariable String username){
	User user = 	this.userrepo.findByUsername(username);
	User useremail = this.userrepo.findByEmail(username);
	System.out.println(user);
	 if(user == null && useremail == null) {
		 return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }else if(useremail == null && user !=null) {
		 
		 String email = user.getEmail();
		 String otp = generateOTP(6);
		 this.emailService.sendEmail(otp, " otp password change", email);
		 Forgotpassword fp = new Forgotpassword();
		 fp.setUsername(user.getUsername());
		 fp.setOtp( otp);
		 this.fprepo.save(fp);
		 return ResponseEntity.ok("opt send successfully");
		 
	 }else if(user == null && useremail !=null) {
		 String email = useremail.getEmail();
		 String otp = generateOTP(6);
		 this.emailService.sendEmail(otp, " otp password change", email);
		 Forgotpassword fp = new Forgotpassword();
		 fp.setUsername(useremail.getEmail());
		 fp.setOtp( otp);
		 this.fprepo.save(fp);
		 return ResponseEntity.ok("opt send successfully");
		 
	 }
	 return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	 public static String generateOTP(int length) {
	        SecureRandom random = new SecureRandom();
	        StringBuilder otp = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            otp.append(random.nextInt(10));
	        }

	        return otp.toString();
	    }
	 
	 @GetMapping("/email/otp/{otp}/{username}")
	 public ResponseEntity<?> validateUserbyotp(@PathVariable String otp,
			 @PathVariable String username){
		 
		 Forgotpassword fp = this.fprepo.findByUsername(username);
		 if(fp == null) {
			 return  new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		 }
		 System.out.println(fp.getUsername());
		 System.out.println(fp.getOtp());
		 if((String.valueOf(fp.getOtp()).equals(otp)) && fp.getUsername().equals(username)) {
			 return ResponseEntity.ok("valid User you can change password");
		 }else {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		 }
		 
	 }
	 @PostMapping("/password-change")
	 public ResponseEntity<?> passwordChange(@RequestBody PasswordChange passwordChange){
		 
		 if(passwordChange.getPassword() != null) {
			 
			 User user = this.userrepo.findByUsername(passwordChange.getUsername());
			 User user1 = this.userrepo.findByEmail(passwordChange.getUsername());
			 
			 if(user != null && user1 == null) {
				 user.setPassword(passwordEncoder.encode( passwordChange.getPassword()));

			 this.userrepo.save(user);
			 }
			 else if(user1 !=null && user == null) {
				 user1.setPassword(passwordEncoder.encode( passwordChange.getPassword()));

				 this.userrepo.save(user1);

			 }
			 
			 return ResponseEntity.ok("saved changed password");
		 }
		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
	 }
	 
 }
