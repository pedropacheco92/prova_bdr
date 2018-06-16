import { Car } from './../models/car';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const url = 'http://localhost:8080/v1/cars';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  getAllCars(): Observable<Car[]> {
    return this.http.get<Car[]>(url);
  }
}
