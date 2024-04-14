import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8082';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + '/api/test/all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + '/api/test/user', { responseType: 'text' });
  }
  
  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + '/api/test/mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + '/api/test/admin', { responseType: 'text' });
  }
  updateUser(user: any) : Observable<any> {
    return this.http.put(API_URL + '/api/user/edit/'+user.id, user, { responseType: 'json' });
  }
  getUser(id: any): Observable<any> {
    return this.http.get(API_URL + '/api/user/get/' + id, { responseType: 'json' });
  }
  getAllUsers(): Observable<any> {
    return this.http.get(API_URL + '/api/user/show', { responseType: 'json' });
  }
  deleteUser(id: any): Observable<any> {
    return this.http.delete(API_URL + '/api/user/delete/' + id, { responseType: 'json' });
  }
}
