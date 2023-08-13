# Angular application

This directory is the root of the Angular application. It was generated using the Angular CLI.
It shows a simple directory structure with some components to show how to use Angular in combination with the Quarkus backend.

To start the development server, you don't need to execute `ng serve` directly. Instead, you can use the Quarkus development mode,
which will start the Angular development server automatically.
Then access it through Quinoa on `http://localhost:8080` since authentication only works here.
The Angular dev server will still be available on `http://localhost:4200`.

# New components

To create new components, services or other Angular elements, you can use the Angular CLI.
Run `ng generate component component-name` to generate a new component.
You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.
