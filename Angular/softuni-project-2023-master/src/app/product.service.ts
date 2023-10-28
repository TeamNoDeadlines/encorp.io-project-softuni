import { Injectable } from '@angular/core';
import { Product } from './models/product';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}
  // products: Product[]
  

  // public getProducts() {
  //   return this.http.get<Product[]>('http://localhost:8888/api/products/7')
  // }

  public postProduct(product: Product) {
    this.http
      .post(
        'https://fest-trial-default-rtdb.europe-west1.firebasedatabase.app/products.json',
        product
      )
      .subscribe((responseData) => console.log(responseData));
  }
}