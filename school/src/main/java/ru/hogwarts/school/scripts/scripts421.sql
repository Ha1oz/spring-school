ALTER TABLE student
  ADD CONSTRAINT name_constraint UNIQUE (name);

ALTER TABLE student
    ADD age INTEGER
    DEFAULT 20;

ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK (age >= 16);

ALTER TABLE faculty
    ADD CONSTRAINT name_color_unique UNIQUE (name, color)
