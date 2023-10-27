import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CancelComponent } from './cancel/cancel.component';
import { SuccessComponent } from './success/success.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { LoginComponent } from './login/login.component';
import { MatIconModule } from '@angular/material/icon';
import { NavComponent } from './nav/nav.component';
@NgModule({
  declarations: [
    AppComponent,
    CancelComponent,
    SuccessComponent,
    CheckoutComponent,
    ClientDashboardComponent,
    LoginComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    // add these modules
    MatCardModule,
    MatButtonModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    NavComponent
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}