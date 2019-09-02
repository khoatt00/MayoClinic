import { Users } from './users.model';

import { Component, Input } from '@angular/core';
import { ApiService } from '../shared/apiservice.service';
import { strictEqual } from 'assert';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';

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
        }, error => {
            console.log(error);
        })
    }
}