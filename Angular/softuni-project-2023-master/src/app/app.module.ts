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
<<<<<<< HEAD:Angular/softuni-project-2023-master/src/app/app.module.ts
=======
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { LoginComponent } from './login/login.component';
import { MatIconModule } from '@angular/material/icon';
import { NavComponent } from './nav/nav.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS, MatFormFieldDefaultOptions } from '@angular/material/form-field';
import { MatFormFieldAppearance } from '@angular/material/form-field';
import { ThemePalette } from '@angular/material/core';
import { FooterComponent } from './footer/footer.component';

>>>>>>> 95a2d7c (adding client dash, nav, footer, prod. service):src/app/app.module.ts

@NgModule({
  declarations: [
    AppComponent,
    CancelComponent,
    SuccessComponent,
    CheckoutComponent,
<<<<<<< HEAD:Angular/softuni-project-2023-master/src/app/app.module.ts
=======
    ClientDashboardComponent,
    LoginComponent,
    FooterComponent,


>>>>>>> 95a2d7c (adding client dash, nav, footer, prod. service):src/app/app.module.ts
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    // add these modules
    MatCardModule,
    MatButtonModule,
    HttpClientModule,
<<<<<<< HEAD:Angular/softuni-project-2023-master/src/app/app.module.ts
=======
    MatToolbarModule,
    MatIconModule,
    NavComponent,
    FormsModule, 
    ReactiveFormsModule,
MatFormFieldModule,


>>>>>>> 95a2d7c (adding client dash, nav, footer, prod. service):src/app/app.module.ts
  ],
  providers: [ {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'outline'}}],
  bootstrap: [AppComponent],
})
export class AppModule {}