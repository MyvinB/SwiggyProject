import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { FormBuilder } from '@angular/forms';
import { UserVService } from '../service/user-v.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-logint',
  templateUrl: './logint.component.html',
  styleUrls: ['./logint.component.css']
})
export class LogintComponent implements OnInit {
  user:User = new User();



constructor (private authService:AuthService, private router:Router) {

 }


loginUser() {
  console.log("Login user", this.user);
  this.authService.loginUser(this.user).subscribe(data => {
    console.log("Login successful");
    console.log(data['message']);
    if(data['token']) {
      this.authService.setToken(data['token']);
      this.router.navigate(['/menu']);
    }
    
  });
}

  
  ngOnInit() {

}

}
