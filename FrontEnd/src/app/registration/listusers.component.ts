import { Component, OnInit } from '@angular/core';
import { ApiService } from '../shared/apiservice.service';
import { Users } from './users.model';

@Component({
    templateUrl: './listusers.component.html',
    styleUrls: ['./registration.component.css']
})
export class ListUserComponent {

    users: Array<Users> = [];

    constructor(private apiService: ApiService) {

    }

    ngOnInit() {
        this.apiService.doGet("/user").subscribe(user => {
            this.users = user as Array<Users>;
            console.log(this.users);
        }, error => {
            console.log(error);
        })
    }

}