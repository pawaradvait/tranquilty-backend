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

import tranquiltybackend.tranquiltybackend.Entity.CourseQuiz;
import tranquiltybackend.tranquiltybackend.Repo.CourseQuizRepo;
import tranquiltybackend.tranquiltybackend.Service.CourseQuizService;

@RestController
@RequestMapping("/course-quiz")
@CrossOrigin("*")
public class CourseQuizController {

	@Autowired
	 private CourseQuizService courseQuizService;
	
	@Autowired
	private CourseQuizRepo courseQuizRepo;

	@PostMapping("/")
  public ResponseEntity<?> addCourseQuiz(@RequestBody CourseQuiz courseQuiz){
	  return ResponseEntity.ok(this.courseQuizService.addCourseQuiz(courseQuiz));
  }
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCourseQuiz(){
		return ResponseEntity.ok(this.courseQuizService.getAllCourseQuiz());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseQuizById(@PathVariable Long id){
		return ResponseEntity.ok(this.courseQuizService.getCourseQuizBYId(id));
	}
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getQuizbyCategoryId(@PathVariable Long id){
		
		return ResponseEntity.ok(this.courseQuizRepo.getQuizByCategoryId(id));
	}
	
 }
