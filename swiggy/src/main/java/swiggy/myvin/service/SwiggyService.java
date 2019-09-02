package swiggy.myvin.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import swiggy.myvin.exception.FoodAlreadyExistsException;
import swiggy.myvin.exception.MaxQntException;
import swiggy.myvin.exception.PaymentException;
import swiggy.myvin.model.Cart;
import swiggy.myvin.model.Food;
import swiggy.myvin.model.FoodOrdered;


public interface SwiggyService {
	List<Food> listAll();
	void setQuant(String name,int qnt);
	Optional<Food> findItem(int id);
    Optional<Cart> findCart(int id);
    void addCart(Food food,String userId, int qnt) throws FoodAlreadyExistsException;
//	List<FoodOrdered> getFoodList(String userId);
	Cart getCart(String userId);

	void changeQnt(String operation, String userId, FoodOrdered foodOrdered) throws MaxQntException;
	void payment(String userId) throws PaymentException;



    


}
