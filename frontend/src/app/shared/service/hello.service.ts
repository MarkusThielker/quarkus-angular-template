import { Injectable } from '@angular/core';
import { HelloRemoteService } from '../api/service/hello.remote.service';

@Injectable({
  providedIn: 'root',
})
export class HelloService {

  constructor(private remote: HelloRemoteService) {
  }

  getHello() {
    return this.remote.getHello();
  }
}
