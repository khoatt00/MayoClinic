import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';

import { RouterModule, Routes } from '@angular/router';
import { ListUserComponent } from './registration/listusers.component';
import { AddTimesheetComponent } from './timesheet/addtimesheet.component';
import { UploadComponent } from './upload/upload.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'User/AddUser', component: RegistrationComponent },
  { path: 'User/Listusers', component: ListUserComponent },
  { path: 'Timesheet/add', component: UploadComponent },
  { path: 'Timesheet/view', component: AddTimesheetComponent },
  { path: 'Timesheet/AddTimesheet', component: AppComponent },
  { path: '', redirectTo: 'User/AddUser', pathMatch: 'full' },
  { path: 'User/login', component: LoginComponent },
];
@NgModule({
  declarations: [
    AppComponent, RegistrationComponent, ListUserComponent,
    AddTimesheetComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

