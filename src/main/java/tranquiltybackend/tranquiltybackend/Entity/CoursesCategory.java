package tranquiltybackend.tranquiltybackend.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CoursesCategory {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long ccid;
	private String title;
	private String description;
	@Column(length = 1000000)
	@Lob
	private byte[] courseCategoryImage;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="courseCategory")
	@JsonIgnore
	private List<CourseQuiz> courseQuiz = new ArrayList<>();

}
