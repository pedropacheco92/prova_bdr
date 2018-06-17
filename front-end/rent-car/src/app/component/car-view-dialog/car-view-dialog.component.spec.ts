import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarViewDialogComponent } from './car-view-dialog.component';

describe('CarViewDialogComponent', () => {
  let component: CarViewDialogComponent;
  let fixture: ComponentFixture<CarViewDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarViewDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarViewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
