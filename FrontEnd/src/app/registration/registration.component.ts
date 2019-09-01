
import { Component } from '@angular/core';
import { ApiService } from '../shared/apiservice.service';

@Component({
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
    fullName: String = '';
    email: String = '';
    password: String = '';

    constructor(private apiService: ApiService) { }
    submit(): void {
        let data = {
            "name": this.fullName,
            "address": "something",
            "phone": "123455",
            "username": "ujjwalsingh",
            "password": this.password,
            "confirmPassword": this.password,
            "email": this.email,
            "role": "ADMIN"
        };
        this.apiService.doPost("/user", data).subscribe(response => {
            console.log("add user success");
        }, error => {
            console.error("add user failed");
        })
    }
}