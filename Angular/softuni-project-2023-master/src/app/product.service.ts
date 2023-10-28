import { Injectable } from '@angular/core';
import { Product } from './models/product';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}
  products: Product[]
  // private products: Product[] = [
  //   {
  //     id: 1,
  //     name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 23,
  //     img: 'https://www.boat-lifestyle.com/cdn/shop/products/eb8e0fbd-c412-48b3-9c91-5b49ddf35800_288x.png?v=1673002681',
  //   },
  //   {
  //     id: 2,
  //     name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 60,
  //     img: 'https://www.energysistem.com/cdnassets/products/45305/principal_2000.jpg',
  //   },
  //   {
  //     id: 3,
  //     name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 125,
  //     img: 'https://www.marshallheadphones.com/on/demandware.static/-/Sites-zs-master-catalog/default/dw1394819b/images/marshall/headphones/monitor-ii-anc/large/mh-monitor-II-ANC-large-1.png',
  //   },
  //   {
  //     id: 4,
  //     name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 240,
  //     img: 'https://cdn11.bigcommerce.com/s-k11cg5mzh9/images/stencil/500x659/products/437/135112/fc0078efc5dd4e2b579dd153ea420bc4865818c9cfeab31652d4e20abdd9a3ee__47840.1698434077.png?c=2',
  //   },
  // ];

  public getProducts() {
    return this.http.get<Product[]>('https://fest-trial-default-rtdb.europe-west1.firebasedatabase.app/products.json')
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