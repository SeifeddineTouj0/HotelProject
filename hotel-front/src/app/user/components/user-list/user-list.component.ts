import { Component } from '@angular/core';
import { UserService } from './../../../_services/user.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {

  userList:any = [];

  constructor(private userService : UserService, private router: Router) { }

  ngOnInit(): void {
    
    this.userService.getAllUsers().subscribe({
      next: data => {
        this.userList = data;
        console.log(this.userList);
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.userList = res.message;
          } catch {
            this.userList = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.userList = `Error with status: ${err.status}`;
        }
      }
    });
  }

  

  editUser(id:any){
    this.router.navigate(['/users/edit/'+id]); 
  }
  
  deleteUser(room:any){
    this.userService.deleteUser(room).subscribe({
      next: data => {
        this.userList = this.userList.filter((r:any) => r.id !== room.id);
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.userList = res.message;
          } catch {
            this.userList = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.userList = `Error with status: ${err.status}`;
        }
      }
    });
  }

}
