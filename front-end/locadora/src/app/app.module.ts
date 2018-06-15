import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MatToolbarModule, MatButtonModule, MatIconModule } from '@angular/material';


import { AppComponent } from './app.component';
import { CarsComponent } from './page/cars/cars.component';
import { CarComponent } from './page/car/car.component';

const appRoutes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'main' }
];


@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    CarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      // { enableTracing: true } // <-- debugging purposes only
    ),
    MatToolbarModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
