import { Component } from '@angular/core';
import { RoomService } from '../../services/room.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-room-list-admin',
  templateUrl: './room-list-admin.component.html',
  styleUrls: ['./room-list-admin.component.css']
})
export class RoomListAdminComponent {

  rooms: any;

  constructor(private roomService : RoomService, private router : Router) { }

  ngOnInit() {
  this.roomService.getAllRooms().subscribe(rooms => {
    this.rooms = rooms;
    });
  }
  editRoom(id:any){
    this.router.navigate(['/rooms/edit/'+id]); 
  }
  
  deleteRoom(room:any){
    this.roomService.deleteRoom(room).subscribe({
      next: data => {
        this.rooms = this.rooms.filter((r:any) => r.id !== room.id);
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.rooms = res.message;
          } catch {
            this.rooms = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.rooms = `Error with status: ${err.status}`;
        }
      }
    });
  }


    

}
