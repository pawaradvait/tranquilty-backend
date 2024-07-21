package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranquiltybackend.tranquiltybackend.Entity.Category;
import tranquiltybackend.tranquiltybackend.Repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return this.categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return this.categoryRepo.findById(id).get();
	}

	@Override
	public void deleteCategoryBYID(Long id) {
		// TODO Auto-generated method stub
		this.categoryRepo.deleteById(id);
		
	}

}
