package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranquiltybackend.tranquiltybackend.Entity.CourseQuestion;
import tranquiltybackend.tranquiltybackend.Repo.CourseQuestionRepo;
@Service
public class CourseQuestionServiceIMpl implements CourseQuestionService {

	
	@Autowired
	private CourseQuestionRepo courseQuestionRepo;
	
	@Override
	public CourseQuestion addCourseQuestion(CourseQuestion courseQuestion) {
		// TODO Auto-generated method stub
		return this.courseQuestionRepo.save(courseQuestion);
	}

	@Override
	public List<CourseQuestion> getAllQuestion() {
		// TODO Auto-generated method stub
		return this.courseQuestionRepo.findAll();
	}

	@Override
	public CourseQuestion getCourseQuestionById(Long id) {
		// TODO Auto-generated method stub
		return this.courseQuestionRepo.findById(id).get();
	}

}
