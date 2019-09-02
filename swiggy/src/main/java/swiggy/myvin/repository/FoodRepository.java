package swiggy.myvin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import swiggy.myvin.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	@Query("from Food m where m.name=:name")
	public Food getFood(@Param("name") String name);
	
}
