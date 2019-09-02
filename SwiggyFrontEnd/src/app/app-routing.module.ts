import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SwiggyComponent } from './swiggy/swiggy.component';
import { LinkComponent } from './link/link.component';
import { AppComponent } from './app.component';
import { LogintComponent } from './logint/logint.component';
import { AuthGuardService } from './service/auth-guard.service';

const routes: Routes = [


{ path:'',component:LogintComponent},
{ path:'menu',component:SwiggyComponent,canActivate:[AuthGuardService]},
{ path:'link',component:LinkComponent,canActivate:[AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

