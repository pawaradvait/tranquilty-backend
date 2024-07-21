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

import com.sun.mail.iap.Response;

import tranquiltybackend.tranquiltybackend.Entity.CourseQuestion;
import tranquiltybackend.tranquiltybackend.Repo.CourseQuestionRepo;
import tranquiltybackend.tranquiltybackend.Service.CourseQuestionService;

@RestController
@RequestMapping("/course-question")
@CrossOrigin("*")
public class CourseQuestionController {

	@Autowired
	private CourseQuestionService courseQuestionService;
	
	
	@Autowired
	private CourseQuestionRepo courseQuestionRepo;
	
	@PostMapping("/")
	public ResponseEntity<?> addCourseQuestion(@RequestBody CourseQuestion courseQuestion){
		return ResponseEntity.ok(this.courseQuestionService.addCourseQuestion(courseQuestion));
	}

@GetMapping("/")
public ResponseEntity<?> getAllCourseQuestion(){
	return ResponseEntity.ok(this.courseQuestionService.getAllQuestion());
}

@GetMapping("/{id}")
public ResponseEntity<?> getCourseQuestionById(@PathVariable Long id){
	return ResponseEntity.ok(this.courseQuestionService.getCourseQuestionById(id));
}

@GetMapping("/quiz/{id}")
public ResponseEntity<?> getCourseQuestionbyquizID(@PathVariable Long id){
	
	return ResponseEntity.ok(this.courseQuestionRepo.getCourseByQuizId(id));
}
}
