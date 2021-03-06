import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = 'http://localhost:4000/products';
  constructor(private http: HttpClient) { }

  getAll(title = "", page = 1, limit = 20): Observable<Product[]> {
    return this.http.get<Product[]>(`http://localhost:8080/products?title=${title}&page=${page - 1}&limit=${limit}`);
  }
}