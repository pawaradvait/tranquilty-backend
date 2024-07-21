package tranquiltybackend.tranquiltybackend.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class CourseQuiz {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long qid;
	private boolean active;
	private String description;
	private int maxMarks;
	private int nosOfQuestion;
	private String title;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="courseQuiz")
	@JsonIgnore
	private List<CourseQuestion> courseQuestions = new ArrayList<>();
	
	
	@ManyToOne
	private CoursesCategory courseCategory ;
	
	@OneToMany(cascade =CascadeType.ALL,mappedBy="courseQuiz")
	@JsonIgnore
	private List<CourseSolvedInfo> courseSolvedInfo = new ArrayList<>();
	
	
	@OneToMany(cascade =CascadeType.ALL,mappedBy="courseQuiz")
	@JsonIgnore
	private List<CourseCertificate> courseCewrtificate= new ArrayList<>();
	
}
