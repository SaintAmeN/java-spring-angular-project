import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllSalesListComponent } from './all-sales-list.component';

describe('AllSalesListComponent', () => {
  let component: AllSalesListComponent;
  let fixture: ComponentFixture<AllSalesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllSalesListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllSalesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
