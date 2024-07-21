package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import tranquiltybackend.tranquiltybackend.Entity.CourseQuestion;

public interface CourseQuestionService {
  
	CourseQuestion addCourseQuestion(CourseQuestion courseQuestion);
	List<CourseQuestion> getAllQuestion();
	CourseQuestion getCourseQuestionById(Long id);
	 
}
