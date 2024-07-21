package tranquiltybackend.tranquiltybackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tranquiltybackend.tranquiltybackend.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
