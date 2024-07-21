package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import tranquiltybackend.tranquiltybackend.Entity.Question;

public interface QuestionService {

	
	Question addQuestion(Question question);
	List<Question> getQuestionOfPaticularQuiz(Long id);
	void DeleteQuestionById(Long id);
	
}
