import { TranslateService } from '@ngx-translate/core';
import { Car } from './../../models/car';
import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource, MatPaginator, MatSort, MatDialog } from '@angular/material';
import { CarService } from '../../service/car.service';
import { CarViewDialogComponent } from '../../component/car-view-dialog/car-view-dialog.component';

@Component({
  selector: 'app-cars',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarsComponent implements OnInit {

  displayedColumns = ['model', 'year', 'color', 'action'];
  dataSource: MatTableDataSource<Car>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(CarViewDialogComponent) carView: CarViewDialogComponent;

  constructor(private router: Router, private carService: CarService, private dialog: MatDialog, private translate: TranslateService) {
    this.carService.getAllCars().subscribe(cars => {
      this.dataSource = new MatTableDataSource(cars);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  ngOnInit() {
  }

  applyFilter(filterValue: string): void {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  addClicked(): void {
    this.router.navigate(['/car']);
  }

  onEdit(row: Car): void {
    this.router.navigate(['/car'], {queryParams: {id: row.id}});
  }

  onView(car: Car): void {
    const dialogRef = this.dialog.open(CarViewDialogComponent, {
      width: '250px',
      data: { car }
    });
  }

  onDelete(row: Car) {
    this.carService.deleteCar(row.id).subscribe(result => {
      if (result) {
        this.carService.getAllCars().subscribe(cars => {
          this.dataSource = new MatTableDataSource(cars);
        });
      } else {
        alert('Erro no deletar');
      }
    });
  }

}
