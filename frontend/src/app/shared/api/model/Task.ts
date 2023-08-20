export interface ITask {
  id: string;
  name: string;
  description: string;
  checked: boolean;
  createdAt: Date;
  updatedAt: Date;
}

export class Task implements ITask {

  id: string;
  name: string;
  description: string;
  checked: boolean;
  createdAt: Date;
  updatedAt: Date;

  constructor() {
    this.id = '';
    this.name = '';
    this.description = '';
    this.checked = false;
    this.createdAt = new Date();
    this.updatedAt = new Date();
  }
}
