package tranquiltybackend.tranquiltybackend.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import tranquiltybackend.tranquiltybackend.Entity.Category;
import tranquiltybackend.tranquiltybackend.Service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ObjectMapper mapper;
	
	@PostMapping("/")
	public ResponseEntity<?>  addCategory(@RequestParam("category") String category,
			@RequestPart("file") MultipartFile file
			) throws IOException{
		
	Category catgeory=	mapper.readValue(category, Category.class);
  
	 Category catgeory_converted = Category.builder().title(catgeory.getTitle()).description(catgeory.getDescription()).category_image(file.getBytes()).build();
	 
	
	
	
	
	return ResponseEntity.ok(this.categoryService.addCategory(catgeory_converted));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getallaCategory(){
		return ResponseEntity.ok(this.categoryService.getAllCategory());
	}
 
}
