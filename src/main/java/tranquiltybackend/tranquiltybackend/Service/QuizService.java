package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import tranquiltybackend.tranquiltybackend.Entity.Quiz;

public interface QuizService {

	Quiz addQuiz(Quiz quiz);
	List<Quiz> getallQuiz();
	Quiz  getQuizbyId(Long id);
	void deleteQuizbyId(Long id);
	 List<Quiz>  getAllQuizByCategoryId(Long catid);
}
