package tranquiltybackend.tranquiltybackend.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.annotation.MultipartConfig;
import tranquiltybackend.tranquiltybackend.Entity.CoursesCategory;
import tranquiltybackend.tranquiltybackend.Service.CourceCategoryService;

@RestController
@RequestMapping("/course-category")
@CrossOrigin("*")

public class CourceCategoryController {

	@Autowired
	private CourceCategoryService courseCategoryService;
	@Autowired
	private ObjectMapper mapper;

	@PostMapping("/")
	public ResponseEntity<?> addCourseCategory(@RequestParam("courseCategory1") String courseCategory1,
		 
			@RequestPart("file") MultipartFile file
			
			) throws IOException{
		
	CoursesCategory courseCategory=	mapper.readValue(courseCategory1, CoursesCategory.class);
		 
		CoursesCategory cc =CoursesCategory.builder().title(courseCategory.getTitle()).description(courseCategory.getDescription())
		.courseCategoryImage(file.getBytes()).build();
		
		return ResponseEntity.ok(this.courseCategoryService.addCourseCategory(cc));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCourseCategory(){
		return ResponseEntity.ok(this.courseCategoryService.getAllCourseCategory());
	}
	
}
