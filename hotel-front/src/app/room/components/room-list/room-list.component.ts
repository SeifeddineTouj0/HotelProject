import { Component } from '@angular/core';
import { RoomService } from './../../services/room.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent {

  roomList:any = [];

  constructor(private roomService : RoomService, private router: Router) { }

  ngOnInit(): void {
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

  

}
