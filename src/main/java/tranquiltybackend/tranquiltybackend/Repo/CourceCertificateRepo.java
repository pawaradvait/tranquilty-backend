package tranquiltybackend.tranquiltybackend.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tranquiltybackend.tranquiltybackend.Entity.CourseCertificate;

public interface CourceCertificateRepo extends JpaRepository<CourseCertificate, UUID>{

	@Query("select c from CourseCertificate c where c.user.userid = :id AND c.courseQuiz.qid = :qid")
	CourseCertificate getCourseCertificateBYuserId(Long id,Long qid);
	
}
