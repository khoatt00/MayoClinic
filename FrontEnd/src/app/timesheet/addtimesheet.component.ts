import { ApiService } from './../shared/apiservice.service';
import { Component } from '@angular/core';

@Component({
    templateUrl: './addtimesheet.component.html',
    styleUrls: ['./timesheet.component.css']
})
export class AddTimesheetComponent {


    path: Array<File> = [];
    constructor(public apiService: ApiService) {

    }

    ngOnInit() {
        this.apiService.doGet("/user/timesheet").subscribe(path => {
            this.path = path as Array<File>;
            console.log(this.path);
        }, error => {
            console.log(error);
        })
    }

}