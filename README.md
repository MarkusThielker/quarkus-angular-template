# 🌐 Quarkus Angular Template

This is a template project for an Angular application with a Quarkus backend.
Thereby the Angular application is built and served by the Quarkus backend using the Quarkus Quinoa extension.

## Getting Started

To run the application and start developing, you can use the IntelliJ IDEA run configuration `Quarkus Angular Template`.
If you want to run the application from the command line, you can use the following command:

```shell
./gradlew quarkusDev # start quarkus in dev mode
```

You need to have Docker installed, since the Quarkus application will start multiple containers for data storage and
authentication.

### What happens on start?

The Quarkus application will connect to the Postgres database and create tables for all entities.
Then it will build the Angular application and serve it on `http://localhost:8080`. The API is available
on `http://localhost:8080/api`.

The API is protected by a Keycloak instance.
This Keycloak is started by Quarkus as a so called 'dev service'.
This means that it is only started in dev mode and will be removed when the application is stopped.
That's why we start the database manually. We want to keep the data between restarts.

The Credentials for the Keycloak instance are by the way `admin:admin` and `alice:alice`.
