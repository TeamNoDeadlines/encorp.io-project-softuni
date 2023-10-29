import { Component } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../models/product';
@Component({
  selector: 'app-business-dashboard',
  templateUrl: './business-dashboard.component.html',
  styleUrls: ['./business-dashboard.component.css']
})

export class BusinessDashboardComponent {
  products: Product[] = [];
  constructor(private productService: ProductService){}

  ngOnInit() {
    this.productService.getProductsFromCompany('BusinessName1').subscribe( products => {
      this.products = products
      console.log(products)
    })
  }
}