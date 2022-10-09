import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service/authentication-service.service';
import { BACKEND_BASE_URL } from '../model/constants';
import { ReportSaleRequest, Sale } from '../model/sale';

@Component({
  selector: 'app-report-sale-form',
  templateUrl: './report-sale-form.component.html',
  styleUrls: ['./report-sale-form.component.css']
})
export class ReportSaleFormComponent implements OnInit {

  request: ReportSaleRequest = {
    productName: '',
    quantity: 0,
    unitPrice: 1.0,
    contractId: '',
    userId: 0,
  }

  constructor(
    private authService: AuthenticationServiceService,
    private httpClient: HttpClient,
    private snackBar: MatSnackBar,
    private router: Router) {
    this.request.userId = authService.getUserId()!
  }

  ngOnInit(): void {

  }

  sendReportSaleRequest(): void {
    this.httpClient.post<Sale>(BACKEND_BASE_URL + 'sale', this.request)
      .subscribe({
        next: (data) => {
          this.snackBar.open('Sale reported successfully!', undefined, {
            verticalPosition: 'top',
            horizontalPosition: 'start',
            duration: 2000
          })

          this.router.navigate(['/mysales'])
        },
        error: (error) => {
          console.log('Error : ' + error)
          this.snackBar.open('Failed to report sale!', undefined, {
            verticalPosition: 'top',
            horizontalPosition: 'start',
            duration: 2000
          })
        }
      })
  }
}
