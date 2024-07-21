package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import jakarta.transaction.Transactional;
import tranquiltybackend.tranquiltybackend.Entity.User;
import tranquiltybackend.tranquiltybackend.Entity.UserRoles;
import tranquiltybackend.tranquiltybackend.Repo.RolesRepo;
import tranquiltybackend.tranquiltybackend.Repo.UserRepo;

@Service
public class UserServiceimpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RolesRepo rolesRepo;
	
	 @Transactional
	    public User addUser(User user, Set<UserRoles> userRoles) throws Exception {
	        User existingUser = this.userRepo.findByUsername(user.getUsername());
	        if (existingUser != null) {
	            throw new Exception("Username already exists");
	        }

	        // Save user first
	        User savedUser = this.userRepo.save(user);

	        // Set the saved user in UserRoles and save roles
	        for (UserRoles userRole : userRoles) {
	            userRole.setUser(savedUser);
	            this.rolesRepo.save(userRole.getRoles());
	        }

	        savedUser.setUserroles(userRoles);

	        // Save UserRoles
	        return this.userRepo.save(savedUser);
	    }
	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return this.userRepo.findAll();
	}

	@Override
	public User getUserbyId(Long id) {
		// TODO Auto-generated method stub
		return this.userRepo.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepo.save(user);
	}

	@Override
	public void deleteUserbyId(Long id) {
		// TODO Auto-generated method stub
		this.userRepo.deleteById(id);
	}
	@Override
	public User findByEmail(String email) {
		
		return this.userRepo.findByEmail(email);
	}

	
}
