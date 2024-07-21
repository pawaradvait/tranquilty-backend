package tranquiltybackend.tranquiltybackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tranquiltybackend.tranquiltybackend.Entity.UserRoles;

public interface UserRoleRepo extends JpaRepository<UserRoles, Long>{

}
