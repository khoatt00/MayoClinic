import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class ApiService {
    constructor(private httpClient: HttpClient) { }

    baseApi: string = 'http://localhost:8081/api/';
    doPost(uri: string, data: Object): Observable<Object> {
        let actualUri: string = this.baseApi.concat(uri);
        return this.httpClient.post(actualUri, data);
    }

}