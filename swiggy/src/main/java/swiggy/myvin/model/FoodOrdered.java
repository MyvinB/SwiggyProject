package swiggy.myvin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodOrdered {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int qnt;
public int getQnt() {
	return qnt;
}
public void setQnt(int qnt) {
	this.qnt = qnt;
}
public FoodOrdered() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodName) {
	this.foodName = foodName;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
private String foodName;
private int cost;

}
