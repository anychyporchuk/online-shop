import { Component, OnInit } from '@angular/core';
import { faCoffee, faSearch, faShoppingCart } from '@fortawesome/free-solid-svg-icons';
import { select, Store } from '@ngrx/store';
import { Product } from 'src/app/models/product';
import { clearProductsBeforeSearch, loadProducts } from 'src/app/product/store/action/product.actions';
import { ProductState } from 'src/app/product/store/reducer/product.reducer';
import { selectCart } from 'src/app/product/store/selector/product.selectors';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  faCoffee = faCoffee;
  faSearch = faSearch;
  faShoppingCart = faShoppingCart;
  searchTitle: string = "";
  cart: Product[] = [];

  constructor(private store: Store<ProductState>) { 
    this.store.pipe(select(selectCart)).subscribe(data => {this.cart = data});
  }

  ngOnInit(): void {
  }

  searchProducts() {
    this.store.dispatch(clearProductsBeforeSearch());
    this.store.dispatch(loadProducts(this.searchTitle, {page: 1, limit:20}));
  }

}
