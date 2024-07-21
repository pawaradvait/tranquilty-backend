package tranquiltybackend.tranquiltybackend.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseQuestion {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long qid;
	private String content;
	private String answer;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	
	@ManyToOne
	private CourseQuiz courseQuiz ; 
}
