CREATE TABLE car (
  id SERIAL,
  brand VARCHAR(255),
  model VARCHAR(255),
  price NUMERIC
);

ALTER TABLE car
    ADD CONSTRAINT id_constraint PRIMARY KEY (id);

CREATE TABLE person (
  id SERIAL,
  name VARCHAR(255) PRIMARY KEY,
  age INTEGER CHECK (age >= 18),
  is_licensed BOOLEAN,
  car_id SERIAL REFERENCES car (id)
);

-- --------------------------------------------------------------

SELECT student.name, student.age, faculty.name, faculty.color
FROM student
INNER JOIN faculty ON student.faculty_id = faculty.id;

SELECT student.name, student.age
FROM student
INNER JOIN avatar ON student.id = avatar.student_id;
