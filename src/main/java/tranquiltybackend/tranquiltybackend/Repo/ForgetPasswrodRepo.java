package tranquiltybackend.tranquiltybackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tranquiltybackend.tranquiltybackend.Entity.Forgotpassword;

public interface ForgetPasswrodRepo extends JpaRepository<Forgotpassword, String>{

	Forgotpassword findByUsername(String username);

}
