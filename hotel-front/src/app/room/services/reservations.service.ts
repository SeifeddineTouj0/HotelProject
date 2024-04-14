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

  getAllReservations(): Observable<any> {
    return this.http.get(API_URL + '/api/reservations/show', { responseType: 'json' });
  }

  editReservation(reservation: any) {
    return this.http.put(API_URL + '/api/reservations/edit'+reservation.id, reservation, { responseType: 'json' }); 
  }

  deleteReservation(id: any) : Observable<any> {
    console.log(id)
    return this.http.delete(API_URL + '/api/reservations/delete/'+id, { responseType: 'json' });
  }

  getUserReservations(id: any): Observable<any>{
    return this.http.get(API_URL+'/api/reservations/user/'+id,{responseType:'json'})
  }

  


}
