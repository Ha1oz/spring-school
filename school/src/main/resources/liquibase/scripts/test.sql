-- liquibase formatted sql

-- changeset haloz:1
CREATE TABLE test_table(
  id SERIAL,
  test_field TEXT
);

-- changeset haloz:2
ALTER TABLE test_table
ADD COLUMN test_field_2 NUMERIC;