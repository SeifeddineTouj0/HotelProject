import { Component } from '@angular/core';
import { RoomService } from './../../services/room.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent {

  roomList:any = [];
  searchForm : FormGroup | undefined;

  constructor(private roomService : RoomService, private router: Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.initForm();
    this.roomService.getAllRooms().subscribe({
      next: data => {
        this.roomList = data;
        console.log(this.roomList);
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.roomList = res.message;
          } catch {
            this.roomList = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.roomList = `Error with status: ${err.status}`;
        }
      }
    });
  }

  initForm(): void {
    this.searchForm = this.formBuilder.group({
      startDate: [''],
      endDate: ['']
    });
  } 

  onSubmit(): void {
    if (this.searchForm && this.searchForm.invalid) {
      return alert('Please fill all the required fields');
    }
    const { startDate, endDate } = this.searchForm?.value;
    this.roomService.searchRooms(startDate,endDate).subscribe({
      next: data => {
        this.roomList = data;
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.roomList = res.message;
          } catch {
            this.roomList = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.roomList = `Error with status: ${err.status}`;
        }
      }
    });
  }

  editRoom(id:any){
    this.router.navigate(['/rooms/edit/'+id]); 
  }
  
  deleteRoom(room:any){
    this.roomService.deleteRoom(room).subscribe({
      next: data => {
        this.roomList = this.roomList.filter((r:any) => r.id !== room.id);
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.roomList = res.message;
          } catch {
            this.roomList = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.roomList = `Error with status: ${err.status}`;
        }
      }
    });
  }

  bookRoom(id:any){
    this.router.navigate(['/rooms/book/'+id]); 
  } 

  

}
