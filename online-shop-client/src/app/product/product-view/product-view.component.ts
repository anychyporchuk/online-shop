import { Component, Input, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Product } from 'src/app/models/product';
import { addProductToCart, removeProductFromCart } from '../store/action/product.actions';
import { ProductState } from '../store/reducer/product.reducer';

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.css']
})
export class ProductViewComponent implements OnInit {

  inCart = false;
  @Input() product!: Product;

  constructor(private store:Store<ProductState>) { }

  ngOnInit(): void {
  }

  addToCart(item: Product) {
    this.store.dispatch(addProductToCart(item));
    this.inCart = true;
  }

  removeFromCart(item: Product) {
    this.store.dispatch(removeProductFromCart(item));
    this.inCart = false;
  }

}
