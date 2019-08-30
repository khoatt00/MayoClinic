import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';

import { RouterModule, Routes } from '@angular/router';
import { ListUserComponent } from './registration/listusers.component';
import { AddTimesheetComponent } from './timesheet/addtimesheet.component';

const routes: Routes = [
  { path: 'User/AddUser', component: RegistrationComponent },
  { path: 'User/Listusers', component: ListUserComponent },
  { path: 'Timesheet/add', component: AddTimesheetComponent },
  { path: 'Timesheet/AddTimesheet', component: AppComponent },
  { path: '', redirectTo: 'User/AddUser', pathMatch: 'full' },
];
@NgModule({
  declarations: [
    AppComponent, RegistrationComponent, ListUserComponent,
    AddTimesheetComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

