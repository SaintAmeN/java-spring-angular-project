import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSalesListComponent } from './user-sales-list.component';

describe('AllSalesListComponent', () => {
  let component: UserSalesListComponent
    ;
  let fixture: ComponentFixture<AllSalesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserSalesListComponent
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(UserSalesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
