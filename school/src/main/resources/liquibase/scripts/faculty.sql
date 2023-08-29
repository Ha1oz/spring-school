-- liquibase formatted sql

-- changeset haloz:1

CREATE INDEX faculty_name_color_index ON faculty(name, color);