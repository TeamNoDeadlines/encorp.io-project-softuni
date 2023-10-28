import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ProductService } from '../product.service';
import { Product } from '../models/product';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent {

  constructor(private productService: ProductService){}
  newProduct: Product = { product_name: '', price: 0, description: '', image_url: '', product_id: 0 };

  onSubmit(form: NgForm) {
    this.newProduct.product_name = form.value.name;
    this.newProduct.price = +form.value.price
    this.newProduct.description = form.value.description;
    this.newProduct.image_url = form.value.image_url;
    this.newProduct.product_id = Math.random()
    console.log(this.newProduct);

this.productService.postProduct(this.newProduct)
    form.reset();
  }


}