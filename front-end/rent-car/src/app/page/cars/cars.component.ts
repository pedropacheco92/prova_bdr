import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  addClicked() {
    this.router.navigate(['/car']);
  }

}
