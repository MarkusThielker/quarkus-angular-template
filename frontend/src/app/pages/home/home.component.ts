import { Component } from '@angular/core';
import { HelloService } from '../../shared/service/hello.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  data: string = 'Loading...';

  constructor(private helloService: HelloService) {
  }

  ngOnInit() {
    setTimeout(() => this.getHello(), 2500);
  }

  getHello() {
    this.helloService.getHello().subscribe((data) => {
      this.data = data;
    });
  }
}
