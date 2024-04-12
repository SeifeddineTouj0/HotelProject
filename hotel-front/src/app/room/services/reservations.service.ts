import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const API_URL = 'http://localhost:8082';
@Injectable({
  providedIn: 'root'
})
export class ReservationsService {
  


  constructor(private http: HttpClient) { }

  addReservation(reservation: any): Observable<any> {
    return this.http.post(API_URL + '/api/reservations/add', reservation, { responseType: 'json' });
  }

  


}
