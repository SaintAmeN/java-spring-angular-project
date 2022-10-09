import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportSaleFormComponent } from './report-sale-form.component';

describe('ReportSaleFormComponent', () => {
  let component: ReportSaleFormComponent;
  let fixture: ComponentFixture<ReportSaleFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportSaleFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReportSaleFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
