import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EffectsModule } from '@ngrx/effects';
import { ProductEffects } from './store/effect/product.effects';
import { ProductViewComponent } from './product-view/product-view.component';
import { StoreModule } from '@ngrx/store';
import { productFeatureKey, reducer } from './store/reducer/product.reducer';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';



@NgModule({
  declarations: [
    ProductViewComponent
  ],
  imports: [
    CommonModule,
    StoreModule.forFeature(productFeatureKey, reducer),
    EffectsModule.forFeature([ProductEffects]),
    FontAwesomeModule
  ],
  exports: [
    ProductViewComponent
  ]
})
export class ProductModule { }
