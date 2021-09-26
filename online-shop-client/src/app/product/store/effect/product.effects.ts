import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { EMPTY } from 'rxjs';
import { map, mergeMap, catchError, switchMap } from 'rxjs/operators';

import { ProductService } from '../../services/product.service';
import { ActionTypes, loadProducts, loadProductsSuccess } from '../action/product.actions';



@Injectable()
export class ProductEffects {

  constructor(
    private actions$: Actions,
    private productService: ProductService) {}

  loadProducts$ = createEffect(() => this.actions$.pipe(
    ofType(loadProducts),
    switchMap(action => this.productService.getAll(action.title, action.pagination.page, action.pagination.limit)
    .pipe(
      map(products => (loadProductsSuccess(products))),
      catchError(() => EMPTY)
    ))
  ))

}
