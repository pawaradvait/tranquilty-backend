package tranquiltybackend.tranquiltybackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tranquiltybackend.tranquiltybackend.Entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long>{

	@Query("select q from Question q where q.quiz.qid = :id")
	List<Question> getQuestionsbyQuizId(Long id);
}
