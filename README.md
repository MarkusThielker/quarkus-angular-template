# 🌐 Quarkus Angular Template

This is a template project for an Angular application with a Quarkus backend.
Thereby the Angular application is built and served by the Quarkus backend using the Quarkus Quinoa extension.

## Getting Started

To run the application and start developing, you can use the IntelliJ IDEA run configuration `Quarkus Angular Template`.
This configuration will also start a Postgres database in a Docker container.

If you do not use IntelliJ IDEA, you can run the application using the following command:

```shell
docker compose up -d postgres # start the database
./gradlew quarkusDev # start quarkus in dev mode
```

### What happens on start?

The Quarkus application will connect to the Postgres database and create tables for all entities.
Then it will build the Angular application and serve it on `http://localhost:8080`. The API is available
on `http://localhost:8080/api`.

The API is protected by a Keycloak instance.
This Keycloak is started by Quarkus as a so called 'dev service'.
This means that it is only started in dev mode and will be removed when the application is stopped.
That's why we start the database manually. We want to keep the data between restarts.

The Credentials for the Keycloak instance are by the way `admin:admin` and `alice:alice`.
