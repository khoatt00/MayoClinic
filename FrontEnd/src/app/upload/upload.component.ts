import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ApiService } from '../shared/apiservice.service';

@Component({
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {
  uploadForm: any = FormGroup;
  public userFile: any = File;

  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private apiService: ApiService) { }

  ngOnInit() {
    this.uploadForm = this.formBuilder.group({
      profile: ['']
    });

  }

  onFileSelect(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.userFile = file;
      console.log(this.userFile);
      this.uploadForm.get('profile').setValue(file);

    }
  }

  onSubmit() {
    // const user = this.uploadForm.value;
    const formData = new FormData();
    // formData.append('user', user);
    formData.append('file', this.uploadForm.get('profile').value);
    this.apiService.doPost("/user/timesheet", formData).subscribe(response => {
      console.log(response);
    }, error => {
      console.log(error);

    })

  }

}
