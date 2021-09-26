import { Component, OnInit } from '@angular/core';
import { faCoffee, faSearch } from '@fortawesome/free-solid-svg-icons';
import { Store } from '@ngrx/store';
import { clearProductsBeforeSearch, loadProducts } from 'src/app/product/store/action/product.actions';
import { ProductState } from 'src/app/product/store/reducer/product.reducer';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  faCoffee = faCoffee;
  faSearch = faSearch;
  searchTitle: string = "";

  constructor(private store: Store<ProductState>) { }

  ngOnInit(): void {
  }

  searchProducts() {
    this.store.dispatch(clearProductsBeforeSearch());
    this.store.dispatch(loadProducts(this.searchTitle, {page: 1, limit:20}));
  }

}
