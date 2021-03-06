import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
 } from '@angular/common/http';
 import { AuthService } from './service/auth.service';
import { $ } from 'protractor';

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    console.log('In token interceptor');
    console.log(this.authService.getToken());
    request = request.clone({
      setHeaders: {

        Authorization: `Bearer ${this.authService.getToken()}`
      }
    });
    return next.handle(request);
  }
}
