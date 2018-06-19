import { CarService } from './../../service/car.service';
import { Car } from './../../models/car';
import { TranslateService } from '@ngx-translate/core';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Color } from '../../models/color';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';

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

  modelForm = new FormControl('', [Validators.required]);
  yearForm = new FormControl('', [Validators.required, Validators.max(this.year), Validators.min(this.year - 30)]);
  colorForm = new FormControl('', [Validators.required]);

  carForm = new FormGroup ({
    id: new FormControl(''),
    model: this.modelForm,
    year: this.yearForm,
    color: this.colorForm
  });

  constructor(private translate: TranslateService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private carService: CarService,
    private snackBar: MatSnackBar) {

    this.activatedRoute.queryParams.subscribe(params => {
      this.edit = params['id'] != null;
      if (this.edit) {
        this.loadCar(params['id']);
        this.label = this.translate.instant('EDIT_CAR');
        this.labelButton = this.translate.instant('SAVE');
      } else {
        this.label = this.translate.instant('NEW_CAR');
        this.labelButton = this.translate.instant('CREATE');
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
    this.snackBar.openFromComponent(SavedSnackBarComponent, {
      duration: 1000,
    });
  }

  onCancelClicked() {
    this.router.navigate(['/car-list']);
  }

  getColor(color) {
    return this.translate.instant(color);
  }

}

@Component({
  selector: 'app-snack-bar-deleted',
  template: '<div>{{ "CAR_SAVED" | translate }}<div>',
  styles: [``],
})
export class SavedSnackBarComponent {

  constructor(private translate: TranslateService) {}

}

