package tranquiltybackend.tranquiltybackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranquiltybackend.tranquiltybackend.Entity.CourseQuiz;
import tranquiltybackend.tranquiltybackend.Repo.CourseQuizRepo;

@Service

public class CourseQuizServiceImpl implements CourseQuizService{

	@Autowired
	private CourseQuizRepo courseQuizRepo;
	
	@Override
	public CourseQuiz addCourseQuiz(CourseQuiz courseQuiz) {
		// TODO Auto-generated method stub
		return this.courseQuizRepo.save(courseQuiz);
	}

	@Override
	public List<CourseQuiz> getAllCourseQuiz() {
		// TODO Auto-generated method stub
		return this.courseQuizRepo.findAll();
	}

	@Override
	public CourseQuiz getCourseQuizBYId(Long id) {
		// TODO Auto-generated method stub
		return this.courseQuizRepo.findById(id).get();
	}

	@Override
	public void deleteCourseQuizbyId(Long id) {
		// TODO Auto-generated method stub
		this.courseQuizRepo.deleteById(id);
	}

}
