import { Component} from '@angular/core';
import { NgForm } from '@angular/forms';
import { ViewEncapsulation } from '@angular/core';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  encapsulation: ViewEncapsulation.None
})

export class AuthComponent {
  constructor(private authService: AuthService){}
  isLoginMode = true;

  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
  }

  onSubmit(form: NgForm) {
    this.authService.signin(form.value.email, form.value.password)
    form.reset();
  }
}