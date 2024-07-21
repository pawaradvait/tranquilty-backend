package tranquiltybackend.tranquiltybackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tranquiltybackend.tranquiltybackend.Entity.CourseQuiz;

public interface CourseQuizRepo extends JpaRepository<CourseQuiz, Long>{
 
	@Query("select q from CourseQuiz q where q.courseCategory.ccid = :id")
	List<CourseQuiz> getQuizByCategoryId(Long id);
}
