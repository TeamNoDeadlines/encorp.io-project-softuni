import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CancelComponent } from './cancel/cancel.component';
import { SuccessComponent } from './success/success.component';
import { BusinessDashboardComponent } from './business-dashboard/business-dashboard.component';
import { AuthComponent } from './auth/auth.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { CreateProductComponent } from './create-product/create-product.component';

const routes: Routes = [
  { path: '', component: ClientDashboardComponent },
  { path: 'business/create-product', component: CreateProductComponent },
  { path: 'business', component: BusinessDashboardComponent },
  { path: 'cancel', component: CancelComponent },
  { path: 'success', component: SuccessComponent },
  { path: 'auth', component: AuthComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
