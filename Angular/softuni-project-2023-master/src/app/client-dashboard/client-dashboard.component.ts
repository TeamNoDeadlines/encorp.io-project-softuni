import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../company.service';
import { ProductService } from '../product.service';
import { Product } from '../models/product';
import { HttpClient } from '@angular/common/http';
import { loadStripe } from '@stripe/stripe-js';
import { environment } from '../../environments/environment';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css'],
})
export class ClientDashboardComponent {
  // value: string;
  // companies: any[] = [];
  // selectedCompany: any;

  products: Product[] = [];
  // stripePromise = loadStripe(environment.stripe);
  //  products: Product[] = [
  //   {
  //     id: 1,
  //     productName: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 23,
  //     imageUrl: 'https://cdn.technomarket.bg/ng/media/cache/mid_thumb/uploads/library/product/09176119/5d83e232f23ea.png.webp',
  //   },
  //   {
  //     product_id: 2,
  //     product_name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 60,
  //     image_url: 'https://www.energysistem.com/cdnassets/products/45305/principal_2000.jpg',
  //   },
  //   {
  //     product_id: 3,
  //     product_name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 125,
  //     image_url: 'https://www.marshallheadphones.com/on/demandware.static/-/Sites-zs-master-catalog/default/dw1394819b/images/marshall/headphones/monitor-ii-anc/large/mh-monitor-II-ANC-large-1.png',
  //   },
  //   {
  //     product_id: 4,
  //     product_name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 240,
  //     image_url: 'https://cdn11.bigcommerce.com/s-k11cg5mzh9/images/stencil/500x659/products/437/135112/fc0078efc5dd4e2b579dd153ea420bc4865818c9cfeab31652d4e20abdd9a3ee__47840.1698434077.png?c=2',
  //   },{
  //     product_id: 5,
  //     product_name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 23,
  //     image_url: 'https://www.boat-lifestyle.com/cdn/shop/products/eb8e0fbd-c412-48b3-9c91-5b49ddf35800_288x.png?v=1673002681',
  //   },
  //   {
  //     product_id: 6,
  //     product_name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 60,
  //     image_url: 'https://www.energysistem.com/cdnassets/products/45305/principal_2000.jpg',
  //   },
  //   {
  //     product_id: 7,
  //     product_name: 'Слушалки',
  //     description:
  //       " With up to 60 Hours of listening time of our over ear headphones in Bluetooth mode, triple as much as other Bluetooth headphones, you'll always have music to inspire you. Come with a 3.5mm audio cable, regardless of whether you want to use wireless headset or wired headphones, Tuitager Bluetooth headset can satisfy you.",
  //     price: 125,
  //     image_url: 'https://www.marshallheadphones.com/on/demandware.static/-/Sites-zs-master-catalog/default/dw1394819b/images/marshall/headphones/monitor-ii-anc/large/mh-monitor-II-ANC-large-1.png',
  //   },
  // ];
  constructor(
    private http: HttpClient,
    private companyService: CompanyService,
    private productService: ProductService
  ) {}

  // async pay(): Promise<void> {
  //   // here we create a payment object
  //   const payment = {
  //     name: 'Iphone',
  //     currency: 'usd',
  //     // amount on cents *10 => to be on dollar
  //     amount: 99900,
  //     quantity: '1',
  //     cancelUrl: 'http://localhost:4200/cancel',
  //     successUrl: 'http://localhost:4200/success',
  //   };

  //   const stripe = await this.stripePromise;

  //   // this is a normal http calls for a backend api
  //   this.http
  //   .post('http://localhost:8888/api/payment', payment)
  //     .subscribe((data: any) => {
  //       // I use stripe to redirect To Checkout page of Stripe platform
  //       stripe?.redirectToCheckout({
  //         sessionId: data.id,
  //       });
  //     });
  // }

  ngOnInit() {
    this.productService.getProductsForClient().subscribe( products => {
      this.products = products
      console.log(products)
    })
  }
  searchCompanies(searchTerm: string) {
    // Implement search logic using the company service
    // if(this.companies){
    //   this.companies = this.companyService.searchCompanies(searchTerm);
    // }
  }

  showProductsServices(company: any) {
    // Fetch products/services for the selected company
    // this.selectedCompany = company;
  }

}