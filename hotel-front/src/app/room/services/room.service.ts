import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const API_URL = 'http://localhost:8082';
@Injectable({
  providedIn: 'root'
})
export class RoomService {
 
  


  constructor(private http: HttpClient) { }

  getAllRooms(): Observable<any> {
    return this.http.get(API_URL + '/api/room/show', { responseType: 'json' });
  }

  addRoom(room: any): Observable<any> {
    return this.http.post(API_URL + '/api/room/add', room, { responseType: 'json' });
  }

  editRoom(room: any): Observable<any> {
    return this.http.put(API_URL + '/api/room/edit', room, { responseType: 'json' });
  }
  
  deleteRoom(id: any): Observable<any> {
    return this.http.delete(API_URL + '/api/room/delete?id=' + id, { responseType: 'json' });
  }

  getRoom(id: any): Observable<any> {
    return this.http.get(API_URL + '/api/room/get?id=' + id, { responseType: 'json' });
  }

  searchRooms(startDate: any, endDate: any): Observable<any> {
    return this.http.get(API_URL + '/api/room/available?startDate=' + startDate + '&endDate=' + endDate, { responseType: 'json' });
  }

  


}
