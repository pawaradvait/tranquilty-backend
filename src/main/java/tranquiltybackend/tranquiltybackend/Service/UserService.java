package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;
import java.util.Set;

import tranquiltybackend.tranquiltybackend.Entity.User;
import tranquiltybackend.tranquiltybackend.Entity.UserRoles;

public interface UserService {

	User addUser(User user,Set<UserRoles> userroles ) throws Exception;
	List<User> getallUser();
	User getUserbyId(Long id);
	User updateUser(User user);
	void deleteUserbyId(Long id);
 
	User findByEmail(String email);
	 
}
