import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../authentication-service/authentication-service.service';
import { BACKEND_BASE_URL } from '../model/constants';
import { Sale } from '../model/sale';

@Component({
  selector: 'app-all-sales-list',
  templateUrl: './user-sales-list.component.html',
  styleUrls: ['./user-sales-list.component.css']
})
export class UserSalesListComponent implements OnInit {
  sales: Sale[] = []

  constructor(
    private httpClient: HttpClient,
    private authService: AuthenticationServiceService
  ) { }

  ngOnInit(): void {
    this.httpClient.get<Sale[]>(BACKEND_BASE_URL + 'sale/' + this.authService.getUserId())
      .subscribe({
        next: (data) => {
          this.sales = data;
        },
        error: (error) => {
          console.log('Error: ' + error)
        }
      })
  }

  getHiddenColumnNames(): string[] {
    return ['sales-person-first-name', 'sales-person-last-name']
  }

}
