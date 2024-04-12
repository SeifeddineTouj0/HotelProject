import { formatDate } from '@angular/common';
import { Component } from '@angular/core';
import { Form, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RoomService } from './../../services/room.service';
import { ReservationsService } from './../../services/reservations.service';
import { StorageService } from 'src/app/_services/storage.service';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent {

  roomId : string | null | undefined;
  reservationForm: FormGroup | undefined;
  userId: string | null | undefined;
  

  constructor(private route : ActivatedRoute, private formBuilder: FormBuilder, private reservationsService : ReservationsService,private storageService : StorageService) { }

  ngOnInit(): void {
    this.roomId = this.route.snapshot.paramMap.get('id');
    this.userId = this.storageService.getUser().id;
    this.initForm();
    console.log(this.roomId);
  }

  initForm(): void {
    this.reservationForm = this.formBuilder.group({
      // id: [''],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      room: [this.roomId, Validators.required],
      user: [this.userId, Validators.required],
    });
  }

  onSubmit(): void {
    if (this.reservationForm && this.reservationForm.invalid) {
      return alert('Please fill all the required fields');
    }
    // Extract individual form values
  const { room, user, startDate, endDate } = this.reservationForm?.value;

  const formData = {
    room: { id: room }, 
    user: { id: user }, 
    startDate,
    endDate
  };


    this.reservationsService.addReservation(formData).subscribe({
      next: data => {
        console.log(data);
        alert('Reservation added successfully');
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            alert(res.message);
          } catch {
            alert(`Error with status: ${err.status} - ${err.statusText}`);
          }
        } else {
          alert(`Error with status: ${err.status}`);
        }
      }
    });
  }

}
