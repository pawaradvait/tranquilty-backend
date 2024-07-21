package tranquiltybackend.tranquiltybackend.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long qid;
	private boolean active;
	private String description;
	private int maxMarks;
	private int nosOfQuestion;
	private String title;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	@OneToMany(cascade=CascadeType.ALL , mappedBy="quiz")
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="quiz")
	@JsonIgnore
	private List<SolvedInfo> solvedInfo  = new ArrayList<>();
	

}
