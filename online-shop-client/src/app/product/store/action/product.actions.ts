import { createAction, props } from '@ngrx/store';
import { Product } from 'src/app/models/product';

export enum ActionTypes {
  Add = '[Product] Add New',
  AddToCart = '[Product] Add to cart',
  RemoveFromCart = '[Product] Remove from cart',
  LoadItems = '[Products] Load items from server',
  LoadSuccess = '[Products] Load success',
}

export const loadProducts = createAction(
  ActionTypes.LoadItems
);

export const loadProductsSuccess = createAction(
  ActionTypes.LoadSuccess,
  (products: Product[]) => ({products})
);

export const addProduct = createAction(
  ActionTypes.Add,
  (product: Product) => ({product})
);

export const addProductToCart = createAction(
  ActionTypes.AddToCart,
  (product: Product) => ({product})
);

export const removeProductFromCart = createAction(
  ActionTypes.RemoveFromCart,
  (product: Product) => ({product})
);