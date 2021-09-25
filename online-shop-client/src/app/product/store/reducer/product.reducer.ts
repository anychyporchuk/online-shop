import { Action, createReducer, on } from '@ngrx/store';
import { Product } from 'src/app/models/product';
import * as ProductActions from '../action/product.actions'


export const productFeatureKey = 'product';

export interface ProductState {
  products: Product[];
  cart: Product[];

}

export const initialState: ProductState = {
  products: [],
  cart: []
};

export const customerReducer = createReducer(
  initialState,
  on(ProductActions.loadProductsSuccess, (state, {products}) => ({ ...state, products: products })),
  on(ProductActions.addProduct, (state: ProductState, {product}) => ({...state, products: [...state.products, product]})),
  on(ProductActions.addProductToCart, (state, {product}) => ({...state, cart: [...state.cart, product]})),
  on(ProductActions.removeProductFromCart, (state, {product}) => ({...state, cart: [...state.cart.filter(item => item.name != product.name)]}))
)


export function reducer(state: ProductState | undefined, action: Action): any {
  return customerReducer(state, action);
}