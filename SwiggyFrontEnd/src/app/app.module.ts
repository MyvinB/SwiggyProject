import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SwiggyComponent } from './swiggy/swiggy.component';
import { LinkComponent } from './link/link.component';
import { NavComponent } from './nav/nav.component';
import { LogintComponent } from './logint/logint.component';
import { UserVService } from './service/user-v.service';
import { AuthGuardService } from './service/auth-guard.service';
import { AuthService } from './service/auth.service';
import { TokenInterceptorService } from './token-interceptor.service';


@NgModule({
  declarations: [
    AppComponent,
    SwiggyComponent,
    LinkComponent,
    NavComponent,
    LogintComponent,
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
  FormsModule,
  MatInputModule,
  MatCardModule,
  MatButtonModule,
  MatToolbarModule,
  HttpClientModule,
  BrowserAnimationsModule,
  MatDialogModule,
  MatSnackBarModule,

  ],
  exports: [
    
    CommonModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatSnackBarModule,
    MatDialogModule,
    MatInputModule
 

  ],

  providers: [UserVService, AuthGuardService,
    AuthService,[SwiggyComponent,
      {
        provide: HTTP_INTERCEPTORS,
        useClass: TokenInterceptorService,
        multi: true
      }
    ]
  ],
  bootstrap: [AppComponent]
  
})
export class AppModule { }
