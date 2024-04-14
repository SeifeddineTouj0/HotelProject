import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/_services/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {


  userForm: FormGroup | undefined;
  availableRoles = [
    { id: 1, name: 'ROLE_USER' },
    { id: 2, name: 'ROLE_MODERATOR' },
    { id: 3, name: 'ROLE_ADMIN' }
  ];

  constructor(private route: ActivatedRoute, private userService : UserService, private formbuilder : FormBuilder) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id){
      this.userService.getUser(id).subscribe({
        next: (data: any) => {
          console.log(data);
          this.initForm();
          this.userForm?.patchValue({
            id: data.id,
            username: data.username,
            email: data.email,
            address: data.address,
            roles: data.roles.map((role: any) => role.id) // Preselect roles based on user data
          });

        },
        error: err => {
          console.log(err);
        }
      });
    }
  }

  initForm(){
    this.userForm = this.formbuilder.group({
      id: [''],
      username: [''],
      email: [''],
      address: [''],
      roles: [[]]
    });
  }

  onSubmit() {
    if (this.userForm?.invalid) {
      return alert('Please fill all the required fields');
    }
  
    const formData = {...this.userForm?.value};
  
    formData.roles = formData.roles.map((roleId: number) => ({ id: roleId }));
  
    this.userService.updateUser(formData).subscribe({
      next: data => {
        console.log(data);
      },
      error: err => {
        console.log(err);
      }
    });
  }



}
