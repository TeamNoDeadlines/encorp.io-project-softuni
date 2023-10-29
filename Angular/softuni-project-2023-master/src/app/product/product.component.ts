import { Component, Input } from '@angular/core';
import { Product } from '../models/product';
import { HttpClient } from '@angular/common/http';
import { loadStripe } from '@stripe/stripe-js';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})

export class ProductComponent {
  @Input() product: Product
  stripePromise = loadStripe(environment.stripe);

  constructor(private http: HttpClient){}

async pay(): Promise<void> {
    // here we create a payment object
    const payment = {
      name: this.product.productName,
      currency: 'bgn',
      // amount on cents *10 => to be on dollar
      amount: this.product.price * 100,
      quantity: '1',
      cancelUrl: 'http://localhost:4200/cancel',
      successUrl: 'http://localhost:4200/success',
    };

    const stripe = await this.stripePromise;
   
    // this is a normal http calls for a backend api
    this.http
    .post('http://localhost:8888/api/payment', payment) 
      .subscribe((data: any) => {
        // I use stripe to redirect To Checkout page of Stripe platform
        stripe?.redirectToCheckout({
          sessionId: data.id,
        });
      });
  }
}