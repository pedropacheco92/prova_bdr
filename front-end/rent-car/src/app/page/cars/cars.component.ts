import { Car } from './../../models/car';
import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { CarService } from '../../service/car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  displayedColumns = ['model', 'year', 'color', 'action'];
  dataSource: MatTableDataSource<Car>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private router: Router, private carService: CarService) {
    this.carService.getAllCars().subscribe(cars => {
      this.dataSource = new MatTableDataSource(cars);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  ngOnInit() {
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  addClicked() {
    this.router.navigate(['/car']);
  }

  onEdit(row: Car) {
    this.router.navigate(['/car'], {queryParams: {id: row.id}});
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
