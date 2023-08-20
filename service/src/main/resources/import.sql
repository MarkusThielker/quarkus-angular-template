INSERT INTO task(id, name, description, checked)
VALUES (1, 'Task 1', 'Description 1', false);

INSERT INTO task(id, name, description, checked)
VALUES (2, 'Task 2', 'Description 2', true);

INSERT INTO task(id, name, description, checked)
VALUES (3, 'Task 3', 'Description 3', false);

ALTER SEQUENCE task_seq RESTART WITH 4;
