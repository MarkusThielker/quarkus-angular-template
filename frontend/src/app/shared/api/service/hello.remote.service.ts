import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../env/environment';

@Injectable({
  providedIn: 'root',
})
export class HelloRemoteService {

  constructor(private http: HttpClient) {
  }

  getHello(): Observable<string> {
    return this.http.get(environment.baseUrlApi + '/hello', {responseType: 'text'});
  }
}
