import { Users } from './users.model';

import { Component, Input } from '@angular/core';
import { ApiService } from '../shared/apiservice.service';

@Component({
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

    constructor(private apiService: ApiService) { }
    user: Users = new Users();
    showForm: boolean = false;
    submitedStatus: string = "";
    message: string = "";

    submit(): void {

        this.apiService.doPost("/user", this.user).subscribe(response => {
            console.log("add user success");
            this.user = new Users();
            this.showForm = true;
            this.submitedStatus = "success";
            this.user = new Users();
            this.message = "User added successfully!!";
        }, error => {
            console.log(error);
            this.showForm = true;
            this.submitedStatus = "failure";
            this.message = error.error.message;
        })
    }
}