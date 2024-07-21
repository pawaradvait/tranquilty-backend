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

import tranquiltybackend.tranquiltybackend.Entity.Question;
import tranquiltybackend.tranquiltybackend.Service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question question){
		
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@GetMapping("/quiz/{id}")
	private ResponseEntity<?> getQuestionByQuizId(@PathVariable Long id){
		
		return ResponseEntity.ok(this.questionService.getQuestionOfPaticularQuiz(id));
	}
	
	
	
}
