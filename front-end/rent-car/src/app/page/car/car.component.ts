import { TranslateService } from '@ngx-translate/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  label = 'label';
  labelButton = 'save';

  constructor(private translate: TranslateService, private router: Router) { }

  ngOnInit() {
  }

  onCancelClicked() {
    this.router.navigate(['/cars']);
  }

}
