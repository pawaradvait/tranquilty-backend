package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import tranquiltybackend.tranquiltybackend.Entity.CoursesCategory;

public interface CourceCategoryService {

	
	CoursesCategory addCourseCategory(CoursesCategory courceCategory);
	List<CoursesCategory> getAllCourseCategory();
	CoursesCategory getCoruseCategoryById(Long id);
	void deleteCourseCategoryById(Long id);
}
