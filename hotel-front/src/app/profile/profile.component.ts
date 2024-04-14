import { Component, OnInit } from '@angular/core';
import { StorageService } from '../_services/storage.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UserService } from './../_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  profileForm : FormGroup | undefined;

  constructor(private userService: UserService,private storageService : StorageService, private formBuilder : FormBuilder) { }

  ngOnInit(): void {
    this.userService.getUser(this.storageService.getUser().id).subscribe({
      next: (data: any) => {
        this.currentUser = data;
        console.log(data);
        this.initForm();
      }
    });


   
  }

  initForm(): void {
    this.profileForm = this.formBuilder.group({
      id: [this.currentUser.id],
      username: [this.currentUser.username],
      email: [this.currentUser.email],
      address: [this.currentUser.address]
    });
  }

  onSubmit(): void {
    if (this.profileForm && this.profileForm.invalid) {
      return alert('Please fill all the required fields');
    }
    const formData = this.profileForm?.value;
    this.userService.updateUser(formData).subscribe({
      next: (data: any) => {
        console.log(data);
        alert('Profile updated successfully');
      },
      error: (err: any) => {
        console.log(err);
        alert('Error updating profile');
      }
    });

  }

}
