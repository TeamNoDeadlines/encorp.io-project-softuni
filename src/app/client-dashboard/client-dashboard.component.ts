// client-dashboard.component.ts
import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../company.service';
import { ProductService } from '../product.service';
import {Product} from '../models/product';
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
  constructor(
    private companyService: CompanyService,
    private productService: ProductService
  ) {}

  ngOnInit() {
    this.products = this.productService.getProducts();
    console.log(this.products)
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
