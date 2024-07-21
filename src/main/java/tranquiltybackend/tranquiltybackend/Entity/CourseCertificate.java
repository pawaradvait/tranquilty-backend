package tranquiltybackend.tranquiltybackend.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = {"user_userid", "courseQuiz_qid"})
	    })
public class CourseCertificate {
 
	   @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	    )
	    @Column(updatable = false, nullable = false)
	    private UUID id;
	
	private String marksObtained;
@ManyToOne
	private User user;
	@ManyToOne
	private CourseQuiz courseQuiz;
	 
}
