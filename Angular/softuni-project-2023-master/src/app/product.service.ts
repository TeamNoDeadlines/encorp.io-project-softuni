import { Injectable } from '@angular/core';
import { Product } from './models/product';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}
  // products: Product[]
  

  public getProductsForClient() {
    return this.http.get<Product[]>('http://localhost:8888/api/products/8')
  }

  public getProductsFromCompany(companyName: string) {
    return this.http.get<Product[]>(`http://localhost:8888/api/allproducts/${companyName}`)
  }

  public postProduct(product: Product) {
    this.http
      .post(
        'https://fest-trial-default-rtdb.europe-west1.firebasedatabase.app/products.json',
        product
      )
      .subscribe((responseData) => console.log(responseData));
  }
}