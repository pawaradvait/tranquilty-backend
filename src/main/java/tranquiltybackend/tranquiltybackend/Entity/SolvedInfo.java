package tranquiltybackend.tranquiltybackend.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(
	    name = "solved_info",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = {"user_userid", "quiz_qid"})
	    })
public class SolvedInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String marksObtained;
	private String correctAnswer;
	private String attempted;
	private boolean eligable;
	
	private LocalDateTime createdAt;

	@ManyToOne
	private Quiz quiz;
	
	@ManyToOne
	private User user;
	
	
	
	
}
