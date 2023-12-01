import { Component } from '@angular/core';
import { CreateTaskRequest, TaskDto, TaskResourceService, UpdateTaskRequest } from "../../shared/api/generated";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css'],
})
export class TaskComponent {

  data: TaskDto[] = [];

  constructor(
    private taskService: TaskResourceService,
  ) {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.apiTaskGet().subscribe(tasks => {
      this.data = tasks;
      console.log('loaded', tasks);
    });
  }

  createTask() {

    const request = {
      name: '',
      description: '',
      checked: false,
    } as CreateTaskRequest

    this.taskService.apiTaskPost(request).subscribe(() => {
      console.log('created');
      this.loadTasks();
    });
  }

  updateTask(task: TaskDto) {

    const request = {
      id: task.id,
      name: task.name,
      description: task.description,
      checked: task.checked,
    } as UpdateTaskRequest;

    this.taskService.apiTaskPut(request).subscribe(() => {
      console.log('updated', task.id);
    });
  }

  deleteTask(task: TaskDto) {

    if (!task.id) throw new Error('task.id is undefined');

    this.taskService.apiTaskIdDelete(task.id).subscribe(() => {
      console.log('deleted', task.id);
      this.loadTasks();
    });
  }
}
