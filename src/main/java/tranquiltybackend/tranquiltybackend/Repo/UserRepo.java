package tranquiltybackend.tranquiltybackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tranquiltybackend.tranquiltybackend.Entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsername(String username);

	User findByEmail(String email);

}
