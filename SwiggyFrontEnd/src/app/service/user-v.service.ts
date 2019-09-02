import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserVService {

  constructor(private http:HttpClient) { }
  
  getCart():Observable<any> {

    return this.http.get("http://localhost:8080/api/ListCart");
  }
  menu():Observable<any> {

    return this.http.get("http://localhost:8080/api/menu");
  }
  saveFood(Food: any,qnt: any):Observable<any> {
    
    return this.http.post("http://localhost:8080/api/Add/"+qnt,Food,{responseType:'text'});
  
  }
  sendQnt(operation: any,Food:any):Observable<any> {
    
    return this.http.post("http://localhost:8080/api/changeQnt/"+operation,Food,{responseType:'text'});
  
  }
  payment():Observable<any> {
    
    return this.http.get("http://localhost:8080/api/pay/",{responseType:'text'});
  
  }

 
}
