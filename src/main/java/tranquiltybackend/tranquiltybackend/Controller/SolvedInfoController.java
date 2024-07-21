package tranquiltybackend.tranquiltybackend.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tranquiltybackend.tranquiltybackend.Entity.SolvedInfo;
import tranquiltybackend.tranquiltybackend.Repo.SolvedInfoRepo;

@RestController
@RequestMapping("/solved-info")
@CrossOrigin("*")
public class SolvedInfoController {
	
	@Autowired
	private SolvedInfoRepo solvedInfoRepo;
	
	
	
	@PostMapping("/")
	public ResponseEntity<?> addSolvedInfo(@RequestBody SolvedInfo solvedInfo){
		solvedInfo.setCreatedAt(LocalDateTime.now());
		return ResponseEntity.ok(this.solvedInfoRepo.save(solvedInfo));
	}
	
	@GetMapping("/user/{userid}")
 public ResponseEntity<?> getSolvedInfoofUser(@PathVariable("userid") Long userid){
		return ResponseEntity.ok(this.solvedInfoRepo.getSolvedInfoByUserId(userid));
	}

	
	@GetMapping("/eligable")
	public ResponseEntity<?> getallEligableUsers(){
		return ResponseEntity.ok(this.solvedInfoRepo.getAllEligableUsersInfo(true));
	}
	 
}
