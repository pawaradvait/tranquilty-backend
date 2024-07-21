package tranquiltybackend.tranquiltybackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tranquiltybackend.tranquiltybackend.Entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{
	
    @Query("SELECT q FROM Quiz q WHERE q.category.cid = :catid")
    List<Quiz> findQuizByCategoryId(@Param("catid") Long catid);
}
