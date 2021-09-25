import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EffectsModule } from '@ngrx/effects';
import { ProductEffects } from './store/effect/product.effects';
import { ProductViewComponent } from './product-view/product-view.component';
import { StoreModule } from '@ngrx/store';
import { productFeatureKey, reducer } from './store/reducer/product.reducer';



@NgModule({
  declarations: [
    ProductViewComponent
  ],
  imports: [
    CommonModule,
    StoreModule.forFeature(productFeatureKey, reducer),
    EffectsModule.forFeature([ProductEffects])
  ],
  exports: [
    ProductViewComponent
  ]
})
export class ProductModule { }
