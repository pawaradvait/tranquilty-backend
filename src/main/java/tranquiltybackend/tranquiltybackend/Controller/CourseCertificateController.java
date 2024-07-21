package tranquiltybackend.tranquiltybackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tranquiltybackend.tranquiltybackend.Entity.CourseCertificate;
import tranquiltybackend.tranquiltybackend.Repo.CourceCertificateRepo;

@RestController
@RequestMapping("/course-certificate")
@CrossOrigin("*")
public class CourseCertificateController {

	@Autowired
	private CourceCertificateRepo courcecertificate;
	
	@PostMapping("/")
	public ResponseEntity<?> addCertificate(@RequestBody CourseCertificate courseCertificate){
		return ResponseEntity.ok(this.courcecertificate.save(courseCertificate));
	}
	
	@GetMapping("/user/{id}/quiz/{qid}")
	public ResponseEntity<?> getCoursecertificateforUser(@PathVariable Long id,@PathVariable Long qid){
		return ResponseEntity.ok(this.courcecertificate.getCourseCertificateBYuserId(id,qid));
	}
	
	
	
}
