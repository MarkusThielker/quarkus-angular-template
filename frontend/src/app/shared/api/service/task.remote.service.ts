import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../env/environment';
import { Task } from '../model/Task';

@Injectable({
  providedIn: 'root',
})
export class TaskRemoteService {

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Task[]>(environment.baseUrlApi + '/task');
  }

  getByPublicId(publicId: string) {
    return this.http.get<Task>(environment.baseUrlApi + `/task/${publicId}`);
  }

  create(task: Task) {
    return this.http.post<Task>(environment.baseUrlApi + `/task`, task);
  }

  update(task: Task) {
    return this.http.put<Task>(environment.baseUrlApi + `/task`, task);
  }

  delete(id: string) {
    return this.http.delete<Task>(environment.baseUrlApi + `/task/${id}`);
  }
}
