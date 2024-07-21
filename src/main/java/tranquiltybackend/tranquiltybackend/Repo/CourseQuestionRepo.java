package tranquiltybackend.tranquiltybackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tranquiltybackend.tranquiltybackend.Entity.CourseQuestion;

public interface CourseQuestionRepo  extends JpaRepository<CourseQuestion, Long> {

	
	@Query("select q from CourseQuestion q where q.courseQuiz.qid = :id")
	public List<CourseQuestion> getCourseByQuizId(Long id);
	
}
