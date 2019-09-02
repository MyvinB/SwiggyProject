package swiggy.myvin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	private int totalCost;

	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	private String userId;

	public int getCartId() {
		return cartId;
	}
	@OneToMany
	private List<FoodOrdered> foodOrdered=new ArrayList<>();
	public String getUserId() {
		return userId;
	}
	public List<FoodOrdered> getFoodOrdered() {
		return foodOrdered;
	}
	public void setFoodOrdered(List<FoodOrdered> foodOrdered) {
		this.foodOrdered = foodOrdered;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	


}
