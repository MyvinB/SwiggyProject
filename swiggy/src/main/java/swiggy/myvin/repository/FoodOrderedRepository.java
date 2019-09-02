package swiggy.myvin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import swiggy.myvin.model.FoodOrdered;



public interface FoodOrderedRepository extends JpaRepository<FoodOrdered, Integer>{

}
