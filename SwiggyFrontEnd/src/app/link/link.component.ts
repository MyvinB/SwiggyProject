import { Component, OnInit } from '@angular/core';
import { UserVService } from '../service/user-v.service';
import { MapType } from '@angular/compiler';
import { Cart } from './cart';
@Component({
  selector: 'app-link',
  templateUrl: './link.component.html',
  styleUrls: ['./link.component.css']
})
export class LinkComponent implements OnInit {
  cart:Cart = new Cart();
 food:Array<any>;

  constructor(private userVService: UserVService) { }
  ngOnInit() {
    this.userVService.getCart().subscribe(data => {
    
      this.cart=data;
      console.log(this.cart.foodOrdered);
      this.food=this.cart.foodOrdered;
      console.log(this.food);
  });

  

 

  //   this.userVService.saveFood(fd,Number).subscribe(data => {
  //     fd = data;
     
  //     console.log(data);
  // });
  

}
minus(fd:any){
  this.userVService.sendQnt("Minus",fd).subscribe(data => {
   
   
    this.userVService.getCart().subscribe(data => {
    
      this.cart=data;
      this.food=this.cart.foodOrdered;
});

});
}
plus(fd:any){
  this.userVService.sendQnt("Plus",fd).subscribe(data => {
    console.log(data);
    if(data!="sucess"){
      alert(data);
    }
    this.userVService.getCart().subscribe(data => {
      this.cart=data;
      this.food=this.cart.foodOrdered;
  });
  });
 
}
pay(){
  this.userVService.payment().subscribe(data => {
  console.log(data+"hello");
  alert(data);
  this.userVService.getCart().subscribe(data => {
    this.cart=data;
    this.food=this.cart.foodOrdered;
  });
});

}

}
