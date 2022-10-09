import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { BACKEND_BASE_URL } from '../model/constants';
import { Sale } from '../model/sale';

@Component({
  selector: 'app-all-sales-list',
  templateUrl: './all-sales-list.component.html',
  styleUrls: ['./all-sales-list.component.css']
})
export class AllSalesListComponent implements OnInit {
  sales: Sale[] = []

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.httpClient.get<Sale[]>(BACKEND_BASE_URL + 'sale')
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
    return []
  }

}
