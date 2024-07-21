package tranquiltybackend.tranquiltybackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tranquiltybackend.tranquiltybackend.Entity.Quiz;
import tranquiltybackend.tranquiltybackend.Service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
		
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	@GetMapping("/category/{catid}")
	public ResponseEntity<?> getAllQuizByCategoryId(@PathVariable Long catid){
		
		return ResponseEntity.ok(this.quizService.getAllQuizByCategoryId(catid));
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getallQuiz(){
		return ResponseEntity.ok(this.quizService.getallQuiz());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getQuizeById(@PathVariable Long id){
		return ResponseEntity.ok( this.quizService.getQuizbyId(id));
				
	}
	
}
