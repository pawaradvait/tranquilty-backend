package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranquiltybackend.tranquiltybackend.Entity.CoursesCategory;
import tranquiltybackend.tranquiltybackend.Repo.CourseCategoryRepo;

@Service
public class CourseCategoryServiceImpl implements CourceCategoryService{

	@Autowired
	 private CourseCategoryRepo courseCategoryRepo;
	
	@Override
	public CoursesCategory addCourseCategory(CoursesCategory courceCategory) {
		// TODO Auto-generated method stub
		return this.courseCategoryRepo.save(courceCategory);
	}

	@Override
	public List<CoursesCategory> getAllCourseCategory() {
		// TODO Auto-generated method stub
		return this.courseCategoryRepo.findAll();
	}

	@Override
	public CoursesCategory getCoruseCategoryById(Long id) {
		// TODO Auto-generated method stub
		return this.courseCategoryRepo.findById(id).get();
	}

	@Override
	public void deleteCourseCategoryById(Long id) {
		// TODO Auto-generated method stub
		this.courseCategoryRepo.deleteById(id);
		
	}

}
