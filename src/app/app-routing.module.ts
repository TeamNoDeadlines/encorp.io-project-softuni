import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CancelComponent } from './cancel/cancel.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { SuccessComponent } from './success/success.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: 'checkout',
    component: CheckoutComponent,
  },
  { path: 'cancel', component: CancelComponent },
  { path: 'success', component: SuccessComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}