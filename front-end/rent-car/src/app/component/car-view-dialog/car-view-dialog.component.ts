import { TranslateService } from '@ngx-translate/core';
import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { Car } from '../../models/car';

@Component({
  selector: 'app-car-view-dialog',
  templateUrl: './car-view-dialog.component.html',
  styleUrls: ['./car-view-dialog.component.css']
})
export class CarViewDialogComponent implements OnInit {

  private car: Car;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    private translate: TranslateService,
    private dialogRef: MatDialog) {
    this.car = data.car;
  }

  ngOnInit() {
  }

  onOkClicked() {
    this.dialogRef.closeAll();
  }

}
