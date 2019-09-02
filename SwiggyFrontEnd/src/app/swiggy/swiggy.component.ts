import { Component, OnInit } from '@angular/core';
import { UserVService } from '../service/user-v.service';
import { LogintComponent } from '../logint/logint.component';
import { Cart } from '../link/cart';
@Component({
  selector: 'app-swiggy',
  templateUrl: './swiggy.component.html',
  styleUrls: ['./swiggy.component.css']
})
export class SwiggyComponent implements OnInit  {
  food:Array<any>;
  cartThere:boolean=false;
  cart:Cart = new Cart();
  foodOrder:Array<any>;
    
  constructor(private userVService: UserVService) {

  }
  OnAddToCart(fd,Number){
    this.cartThere=true;
    console.log(fd.name);
    console.log(Number);
 

    this.userVService.saveFood(fd,Number).subscribe(data => {
     alert(data);
  
     
     
  });


  }
  ngOnInit() {
    this.userVService.menu().subscribe(data => {
      console.log(data)
      this.food = data;
  });
  this.userVService.getCart().subscribe(data => {
    console.log(data.foodOrdered.length);

    if(data.foodOrdered.length!=0){
      console.log("isdfds");
      this.cartThere=true;
    }
    else{
      this.cartThere=false;
    }
    
    this.cart=data;

    this.foodOrder=this.cart.foodOrdered;

});

}
}
