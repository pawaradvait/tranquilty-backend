package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranquiltybackend.tranquiltybackend.Entity.Quiz;
import tranquiltybackend.tranquiltybackend.Repo.QuizRepo;

@Service
public class QuizServiceIMPL implements QuizService{

	@Autowired
	private QuizRepo quizRepo;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> getallQuiz() {
		// TODO Auto-generated method stub
		return this.quizRepo.findAll();
	}

	@Override
	public Quiz getQuizbyId(Long id) {
		// TODO Auto-generated method stub
		return this.quizRepo.findById(id).get();
	}

	@Override
	public void deleteQuizbyId(Long id) {
		// TODO Auto-generated method stub
		this.quizRepo.deleteById(id);
	}

	@Override
	public List<Quiz> getAllQuizByCategoryId(Long catid) {
		
		
		
		return this.quizRepo.findQuizByCategoryId(catid);
	}

}
