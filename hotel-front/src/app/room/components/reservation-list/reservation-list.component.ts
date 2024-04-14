import { Component } from '@angular/core';
import { ReservationsService } from '../../services/reservations.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent {


  reservationList : any = [];

  constructor(private reservationsService : ReservationsService, private router : Router) { }

  ngOnInit(): void {
    this.reservationsService.getAllReservations().subscribe({
      next: data => {
        this.reservationList = data;
        console.log(this.reservationList);
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.reservationList = res.message;
          } catch {
            this.reservationList = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.reservationList = `Error with status: ${err.status}`;
        }
      }
    });
  }

  deleteReservation(id: any) {
    this.reservationsService.deleteReservation(id).subscribe({
      next: () => {
        this.reservationList = this.reservationList.filter((r: any) => r.id !== id);
      },
      error: (err: { error: string; status: any; statusText: any; }) => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.reservationList = res.message;
          } catch {
            this.reservationList = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.reservationList = `Error with status: ${err.status}`;
        }
      }
    });
  }

  editReservation(id: any) {
    this.router.navigate(['admin/reservations/edit/' + id]);
  }




}
