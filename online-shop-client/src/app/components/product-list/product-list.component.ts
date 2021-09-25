import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product';
import { loadProducts } from 'src/app/product/store/action/product.actions';
import { ProductState } from 'src/app/product/store/reducer/product.reducer';
import { selectProducts } from 'src/app/product/store/selector/product.selectors';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products!: Observable<Product[]>;

  constructor(private store: Store<ProductState>) { }

  ngOnInit(): void {
    console.log("ProducList ngOnInit");
    this.products = this.store.pipe(select(selectProducts));
    this.store.dispatch(loadProducts());
  }

}
