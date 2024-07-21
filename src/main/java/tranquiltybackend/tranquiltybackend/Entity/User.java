package tranquiltybackend.tranquiltybackend.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String username;
	private String password;

	private Boolean enable;
	private String phonenos;
	@Lob
	@Column(length = 1000000)
    private byte[] photoUser;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
  @JsonIgnore
	private Set<UserRoles> userroles = new HashSet<>();
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	private List<SolvedInfo> solvedInfo = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	private List<CourseSolvedInfo> courseSolvedInfo = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	private List<CourseCertificate> courseCertificate = new ArrayList<>();
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Authority> set = new HashSet<>();
		 
		this.userroles.forEach(userrole->{
			set.add( new Authority( userrole.getRoles().getRoleName()));
		});
		
		
		return set;
	}
}
