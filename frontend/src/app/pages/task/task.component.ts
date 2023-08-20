import { Component } from '@angular/core';
import { Task } from '../../shared/api/model/Task';
import { TaskService } from '../../shared/service/task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css'],
})
export class TaskComponent {

  data: Task[] = [];

  constructor(
    private taskService: TaskService,
  ) {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.getAll().subscribe(tasks => {
      tasks.map(task => {
        task.createdAt = new Date(task.createdAt);
        task.updatedAt = new Date(task.updatedAt);
      });
      tasks.sort((a, b) => a.createdAt.getTime() - b.createdAt.getTime());
      this.data = tasks;
      console.log('loaded', tasks);
    });
  }

  createTask() {
    this.taskService.create(new Task()).subscribe(() => {
      console.log('created');
      this.loadTasks();
    });
  }

  updateTask(task: Task) {
    this.taskService.update(task).subscribe(() => {
      console.log('updated', task.id);
    });
  }

  deleteTask(task: Task) {
    this.taskService.delete(task.id).subscribe(() => {
      console.log('deleted', task.id);
      this.loadTasks();
    });
  }
}
