package tranquiltybackend.tranquiltybackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tranquiltybackend.tranquiltybackend.Entity.SolvedInfo;

public interface SolvedInfoRepo extends JpaRepository<SolvedInfo, Long>{

	
	@Query("select s from SolvedInfo s where s.user.userid = :userid")
	List<SolvedInfo> getSolvedInfoByUserId(Long userid);
	
	@Query("select s from SolvedInfo s where s.eligable = :data")
	List<SolvedInfo> getAllEligableUsersInfo(boolean data);
	
}
