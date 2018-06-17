import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MatToolbarModule, MatButtonModule, MatIconModule, MatTableModule, MatSortModule,
  MatPaginatorModule, MatTabsModule, MatFormFieldModule, MatInputModule, MatChipsModule,
  MatOptionModule, MatSelectModule, MatCardModule, MatDialogModule } from '@angular/material';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { CarsComponent } from './page/car-list/car-list.component';
import { CarComponent } from './page/car/car.component';
import { MainComponent } from './page/main/main.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CarViewDialogComponent } from './component/car-view-dialog/car-view-dialog.component';

const appRoutes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'main' },
  { path: 'car-list', component: CarsComponent },
  { path: 'car', component: CarComponent },
  { path: 'main', component: MainComponent }
];

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    CarComponent,
    MainComponent,
    CarViewDialogComponent
  ],
  entryComponents: [
    CarViewDialogComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes
    ),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
  }),
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatTabsModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatChipsModule,
    FormsModule,
    ReactiveFormsModule,
    MatOptionModule,
    MatSelectModule,
    MatCardModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
