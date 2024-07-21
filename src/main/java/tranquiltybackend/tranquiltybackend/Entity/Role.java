package tranquiltybackend.tranquiltybackend.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {

	@Id
	
	private Long roleId;
	private String roleName;
	
	@OneToMany(mappedBy="roles",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<UserRoles> userroles = new HashSet<>();
}
