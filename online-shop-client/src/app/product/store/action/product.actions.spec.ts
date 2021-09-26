import { Pagination } from 'src/app/models/product';
import * as fromProduct from './product.actions';

describe('loadProducts', () => {
  it('should return an action', () => {
    expect(fromProduct.loadProducts(new Pagination).type).toBe('[Product] Load Products');
  });
});
