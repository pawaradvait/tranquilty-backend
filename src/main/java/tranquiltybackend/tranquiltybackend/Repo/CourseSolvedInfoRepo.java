package tranquiltybackend.tranquiltybackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tranquiltybackend.tranquiltybackend.Entity.CourseSolvedInfo;

public interface CourseSolvedInfoRepo  extends JpaRepository<CourseSolvedInfo, Long>{

	
	@Query("select c from CourseSolvedInfo c where c.user.userid = :id")
	List<CourseSolvedInfo> getcourseSolvedforUser(Long id);
	
}
