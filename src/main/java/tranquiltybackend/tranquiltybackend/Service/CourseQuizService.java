package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import tranquiltybackend.tranquiltybackend.Entity.CourseQuiz;

public interface CourseQuizService {
	CourseQuiz addCourseQuiz(CourseQuiz courseQuiz);
	List<CourseQuiz> getAllCourseQuiz();
	CourseQuiz getCourseQuizBYId(Long id);
	void deleteCourseQuizbyId(Long id);

}
