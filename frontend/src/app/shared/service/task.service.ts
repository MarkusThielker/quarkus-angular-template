import { Injectable } from '@angular/core';
import { TaskRemoteService } from '../api/service/task.remote.service';
import { Task } from '../api/model/Task';

@Injectable({
  providedIn: 'root',
})
export class TaskService {

  constructor(
    private api: TaskRemoteService,
  ) {
  }

  getAll() {
    return this.api.getAll();
  }

  create(task: Task) {
    return this.api.create(task);
  }

  update(task: Task) {
    return this.api.update(task);
  }

  delete(id: string) {
    return this.api.delete(id);
  }
}
