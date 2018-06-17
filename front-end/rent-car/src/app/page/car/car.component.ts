import { CarService } from './../../service/car.service';
import { Car } from './../../models/car';
import { TranslateService } from '@ngx-translate/core';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Color } from '../../models/color';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  label = '';
  labelButton = '';
  colors = Color.COLORS;

  private edit: boolean;
  private year = new Date().getFullYear();

  carForm = new FormGroup ({
    id: new FormControl(''),
    model: new FormControl('', [Validators.required]),
    year: new FormControl('', [Validators.required, Validators.max(this.year), Validators.min(this.year - 30)]),
    color: new FormControl('', [Validators.required])
  });

  constructor(private translate: TranslateService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private carService: CarService) {

    this.activatedRoute.queryParams.subscribe(params => {
      this.edit = params['id'] != null;
      if (this.edit) {
        this.loadCar(params['id']);
        this.label = 'Edita Carro';
        this.labelButton = 'Salvar';
      } else {
        this.label = 'Novo Carro';
        this.labelButton = 'Criar';
      }
    });
  }

  ngOnInit() {
  }

  loadCar(id: number) {
    this.carService.getCar(id).subscribe(car => {
      this.carForm.setValue(car);
    });
  }

  onSubmit() {
    const car: Car = this.carForm.value;
    if (this.edit) {
      this.carService.editCar(car).subscribe(result => this.router.navigate(['/car-list']));
    } else {
      this.carService.saveCar(car).subscribe(result => this.router.navigate(['/car-list']));
    }
  }

  onCancelClicked() {
    this.router.navigate(['/car-list']);
  }

  getColor(color) {
    return this.translate.instant(color);
  }

}
