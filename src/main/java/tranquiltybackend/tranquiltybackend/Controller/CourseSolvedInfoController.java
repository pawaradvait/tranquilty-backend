package tranquiltybackend.tranquiltybackend.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tranquiltybackend.tranquiltybackend.Entity.CourseSolvedInfo;
import tranquiltybackend.tranquiltybackend.Repo.CourseSolvedInfoRepo;

@RestController
@RequestMapping("/course-solved-info")
@CrossOrigin("*")
public class CourseSolvedInfoController {
 
	@Autowired
	private CourseSolvedInfoRepo solvedInforepo; 
	
	@PostMapping("/")
	public ResponseEntity<?> addSolvedInfo(@RequestBody CourseSolvedInfo courseSolvedInfo){
		courseSolvedInfo.setCreatedAt(LocalDateTime.now());

		return ResponseEntity.ok(this.solvedInforepo.save(courseSolvedInfo));
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getCoursesolvedOfUser(@PathVariable Long id){
		return ResponseEntity.ok(this.solvedInforepo.getcourseSolvedforUser(id));
	}
	
}
