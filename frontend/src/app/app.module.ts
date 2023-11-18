import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TaskComponent } from './pages/task/task.component';
import { FormsModule } from '@angular/forms';
import { ApiModule, Configuration } from "./shared/api/generated";

@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ApiModule.forRoot(() => {
      return new Configuration({
        basePath: `http://localhost:8080`,
      });
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
