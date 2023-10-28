// client-dashboard.component.ts
import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../company.service';
import { ProductService } from '../product.service';
import { Product } from '../models/product';
import { HttpClient } from '@angular/common/http';
import { loadStripe } from '@stripe/stripe-js';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css'],
})
export class ClientDashboardComponent {
  value: string;
  companies: any[] = [];
  selectedCompany: any;
  products: Product[] = [];
  stripePromise = loadStripe(environment.stripe);

  constructor(
    private http: HttpClient,
    private companyService: CompanyService,
    private productService: ProductService
  ) {}

  async pay(): Promise<void> {
    // here we create a payment object
    const payment = {
      name: 'Iphone',
      currency: 'usd',
      // amount on cents *10 => to be on dollar
      amount: 99900,
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
  
  ngOnInit() {
    this.products = this.productService.getProducts();
    console.log(this.products);
  }
  searchCompanies(searchTerm: string) {
    // Implement search logic using the company service
    // if(this.companies){
    //   this.companies = this.companyService.searchCompanies(searchTerm);
    // }
  }

  showProductsServices(company: any) {
    // Fetch products/services for the selected company
    this.selectedCompany = company;
  }
}
