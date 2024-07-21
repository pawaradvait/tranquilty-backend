package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import tranquiltybackend.tranquiltybackend.Entity.Category;

public interface CategoryService {

	Category addCategory(Category category);
	List<Category> getAllCategory();
	Category getCategoryById(Long id);
	void deleteCategoryBYID(Long id);
}
