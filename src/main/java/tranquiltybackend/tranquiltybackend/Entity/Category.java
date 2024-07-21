package tranquiltybackend.tranquiltybackend.Entity;

import java.util.HashSet;
import java.util.Set;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cid;
	private String description;
	private String title;
	@Lob
	@Column(length= 1000000)
	private byte[] category_image;
	

	@OneToMany(cascade=CascadeType.ALL,mappedBy="category")
	@JsonIgnore
	private Set<Quiz> quizes =new HashSet<>();
}
