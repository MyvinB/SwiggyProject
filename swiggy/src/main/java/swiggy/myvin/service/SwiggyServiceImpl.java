package swiggy.myvin.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swiggy.myvin.exception.FoodAlreadyExistsException;
import swiggy.myvin.exception.MaxQntException;
import swiggy.myvin.exception.PaymentException;
import swiggy.myvin.model.Cart;
import swiggy.myvin.model.Food;
import swiggy.myvin.model.FoodOrdered;
import swiggy.myvin.repository.CartRepository;
import swiggy.myvin.repository.FoodOrderedRepository;
import swiggy.myvin.repository.FoodRepository;

@Service
public class SwiggyServiceImpl implements SwiggyService {

	@Autowired
	private FoodRepository Frepository;
	@Autowired
	private CartRepository Crepository;
	@Autowired
	private FoodOrderedRepository FoodOrderrepository;
	@Override
	public List<Food> listAll() {

		String[] name= {"Chicken","Pork","Vegi Delight","Poha"};
		String[] path= {"chk.jpg","prk.jfif","veg.jpg","pho.jpg"};
		int[] amt= {100,200,300,40};		int[] qnt= {12,2,5,5};
//		for(int i=0;i<4;i++) {
//			Food food=new Food();
//			food.setName(name[i]);
//		food.setPath(path[i]);
//			food.setAmt(amt[i]);
//			food.setQnt(qnt[i]);
//			Frepository.save(food);
//	}
		return Frepository.findAll();
	}
	@Override
	public Optional<Food> findItem(int id) {
		Optional<Food> food=Frepository.findById(id);
	
		return food;
		
	}




	@Override
	public void setQuant(String name, int quant) {
	
		Food food=Frepository.getFood(name);
		food.setQnt(food.getQnt()-quant);
		Frepository.save(food);
		
		
	}
	@Override
	public Optional<Cart> findCart(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addCart(Food food,String userId,int qnt) throws FoodAlreadyExistsException {
		Cart cart=Crepository.findByUserId(userId).orElse(null);
		FoodOrdered foodToCart =new FoodOrdered();
		if(cart!=null) {
		List<FoodOrdered> foodOrderedList= cart.getFoodOrdered();
		for(FoodOrdered foodOrder:foodOrderedList) {
			if(foodOrder.getFoodName().equals(food.getName())) {
				throw new FoodAlreadyExistsException("Food in cart already");
				
			}
		}
		foodToCart.setFoodName(food.getName());
		foodToCart.setCost(food.getAmt()*qnt);
		foodToCart.setQnt(qnt);
		foodOrderedList.add(foodToCart);
	
		
		FoodOrderrepository.save(foodToCart);
		Frepository.save(food);
		Crepository.save(cart);
		}
		else {
			foodToCart.setFoodName(food.getName());
			foodToCart.setCost(food.getAmt()*qnt);
			foodToCart.setQnt(qnt);
			FoodOrderrepository.save(foodToCart);
			cart=new Cart();
			cart.setUserId(userId);
			cart.getFoodOrdered().add(foodToCart);
			Crepository.save(cart);
		}
	}

	/*
	 * @Override public List<FoodOrdered> getFoodList(String userId) { Cart
	 * cart=Crepository.findByUserId(userId).orElse(null); return
	 * cart.getFoodOrdered();
	 * 
	 * }
	 */
	@Override
	public Cart getCart(String userId) {
	Cart cart=Crepository.findByUserId(userId).orElse(null);
	List<FoodOrdered> foodList=cart.getFoodOrdered();
	int total=0;
	for(FoodOrdered food:foodList) {
		total=total+food.getCost();
	}
	cart.setTotalCost(total);
	return cart ;
	}
	@Override
	public void changeQnt(String operation, String userId,FoodOrdered foodOrdered) throws MaxQntException {
		
		Cart cart=Crepository.findByUserId(userId).orElse(null);
		List<Food> foodListStation=Frepository.findAll();
		int qntAvail=0;
		for(Food food:foodListStation) {
			if(food.getName().equals(foodOrdered.getFoodName())) {
				qntAvail=food.getQnt();
				System.out.println(qntAvail);
			}
		}
		List<FoodOrdered> foodList=cart.getFoodOrdered();
		FoodOrdered foodTemp=null;
		for(FoodOrdered food:foodList) {
			if(food.getFoodName().equals(foodOrdered.getFoodName())) {
				
				
				
				if(operation.equals("Minus")) {
					int price=food.getCost()/food.getQnt();
					System.out.println(price);
					int qnt=food.getQnt();
					cart.setTotalCost(cart.getTotalCost()-food.getCost());
					if(qnt==1) {
						foodTemp=food;
					}
					else {
					
					food.setQnt(qnt-1);
					food.setCost(price*(qnt-1));
					cart.setTotalCost(cart.getTotalCost()+price*qnt);
					}
				}
				else if(operation.equals("Plus")) {
					if(foodOrdered.getQnt()<qntAvail) {
						int price=food.getCost()/food.getQnt();
						int qnt=food.getQnt();
						cart.setTotalCost(cart.getTotalCost()-food.getCost());
						food.setQnt(qnt+1);
						food.setCost(price*(qnt+1));
						cart.setTotalCost(cart.getTotalCost()+price*qnt);	
					}
					else {
					
						throw new MaxQntException("Max quantity excedd");
						
					}
				}
				
				
			}
		}
		if(foodTemp!=null) {
			cart.getFoodOrdered().remove(foodTemp);
		}
		Crepository.save(cart);

	}
	@Override
	public void payment(String userId) throws PaymentException {
		Cart cart=Crepository.findByUserId(userId).orElse(null);
		Food foodTemp=null;
		FoodOrdered foodOrderedTemp=null;
		List<Food> foodList=Frepository.findAll();
		List<FoodOrdered> foodOrdered=cart.getFoodOrdered();
		for(FoodOrdered foodPlaced:foodOrdered) {
			for(Food foode:foodList) {
				if(foodPlaced.getFoodName().equals(foode.getName())) {
					foode.setQnt(foode.getQnt()-foodPlaced.getQnt());
					foodTemp=foode;
					foodOrderedTemp=foodPlaced;
				}
			}
		
		}
		if(foodTemp!=null&&foodOrderedTemp!=null) {
			
			Frepository.save(foodTemp);
			cart.getFoodOrdered().remove(foodOrderedTemp);
			Crepository.save(cart);
		}
		else {
			throw new PaymentException("Payment Failed");
		}
	
		
	}

	

	
	
	
}
