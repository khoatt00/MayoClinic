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

    submit(): void {

        this.apiService.doPost("/user", this.user).subscribe(response => {
            console.log("add user success");
            this.user = new Users();
        }, error => {
            console.log(error);
        })
    }
}