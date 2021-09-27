import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product';
import { removeProductFromCart } from 'src/app/product/store/action/product.actions';
import { ProductState } from 'src/app/product/store/reducer/product.reducer';
import { selectCart } from 'src/app/product/store/selector/product.selectors';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  products!: Observable<Product[]>;

  constructor(private store: Store<ProductState>) { }

  ngOnInit(): void {
    this.products = this.store.pipe(select(selectCart));
  }

  removeCartItem(item: Product) {
    this.store.dispatch(removeProductFromCart(item));

  }

}
