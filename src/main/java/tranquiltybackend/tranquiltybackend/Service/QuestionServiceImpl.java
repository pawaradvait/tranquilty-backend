package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranquiltybackend.tranquiltybackend.Entity.Question;
import tranquiltybackend.tranquiltybackend.Repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public List<Question> getQuestionOfPaticularQuiz(Long id) {
		// TODO Auto-generated method stub
		return this.questionRepo.getQuestionsbyQuizId(id);
	}

	@Override
	public void DeleteQuestionById(Long id) {
		// TODO Auto-generated method stub
		this.questionRepo.deleteById(id);
	}

}
