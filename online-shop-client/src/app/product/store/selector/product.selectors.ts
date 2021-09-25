import { createFeatureSelector, createSelector } from '@ngrx/store';
import * as fromProduct from '../reducer/product.reducer';

export const selectProductState = createFeatureSelector<fromProduct.ProductState>(
    fromProduct.productFeatureKey,
);

export const selectProducts = createSelector(
    selectProductState,
    (state: fromProduct.ProductState) => state.products
);

export const selectCart = createSelector(
    selectProductState,
    (state: fromProduct.ProductState) => state.cart
);