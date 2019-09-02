package swiggy.myvin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import swiggy.myvin.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
    @Query("SELECT p FROM Cart p WHERE p.userId = :userId")
    public Optional<Cart> findByUserId(@Param("userId") String userId);

	

}
