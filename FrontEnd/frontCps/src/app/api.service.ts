import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  postData(data: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/fee/total/`+localStorage.getItem('token'), data);
  }

  postLogin(data: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, data);
  }
}
