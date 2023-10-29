import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { Auth } from './auth';

@Injectable({ providedIn: 'root' })
export class AuthService {
authData: Auth;
  constructor(private http: HttpClient) {}
  signin(email: string, password: string) {
    this.http.get<Auth>('http://localhost:8888/api/authentication/login', {headers: new HttpHeaders({'AUTHORIZATION': `${email} ${password}` || ''})})
      .subscribe(
        data => this.authData = data
      );
  }
}