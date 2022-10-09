import { Component, Input, OnInit } from '@angular/core';
import { Sale } from '../model/sale';

@Component({
  selector: 'app-sale-list',
  templateUrl: './sale-list.component.html',
  styleUrls: ['./sale-list.component.css']
})
export class SaleListComponent implements OnInit {
  @Input() sales: Sale[] = []
  @Input() hiddenColumnNames: string[] = []

  visibleColumnNames: string[] = [
    'sale-id',
    'product-name',
    'sale-date-time',
    'quantity',
    'avg-unit-price',
    'sales-person-first-name',
    'sales-person-last-name'
  ]

  constructor() { }

  getVisibleColumnNames(): string[] {
    const visibleColumns = []
    for (let i = 0; i < this.visibleColumnNames.length; i++) {
      if(this.hiddenColumnNames.includes(this.visibleColumnNames[i])){
        continue
      }

      visibleColumns.push(this.visibleColumnNames[i]);
    }

    return visibleColumns
  }

  ngOnInit(): void {
  }

}
