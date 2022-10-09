import { NgModule } from '@angular/core';
import { TestComponent } from './test/test.component';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { AdminRoleGuard } from './authentication-service/admin-role.guard';
import { AuthenticationGuard } from './authentication-service/authentication.guard';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { UserSalesListComponent } from './user-sales-list/user-sales-list.component';
import { AllSalesListComponent } from './all-sales-list/all-sales-list.component';
import { ReportSaleFormComponent } from './report-sale-form/report-sale-form.component';

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "test", component: TestComponent },
  { path: "home", component: HomeComponent },
  { path: "login", component: LoginFormComponent },
  { path: "register", component: RegistrationFormComponent },
  { path: "users", component: UserListComponent, canActivate: [AuthenticationGuard, AdminRoleGuard] },

  { path: "mysales", component: UserSalesListComponent, canActivate: [AuthenticationGuard] },
  { path: "report-sale", component: ReportSaleFormComponent, canActivate: [AuthenticationGuard] },
  { path: "sales", component: AllSalesListComponent, canActivate: [AuthenticationGuard, AdminRoleGuard] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
