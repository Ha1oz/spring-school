package ru.hogwarts.school.controllers.restTemplateTests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.controllers.FacultyController;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;

import java.awt.*;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FacultyControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private FacultyController facultyController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(facultyController).isNotNull();
    }

    @Test
    void add() {
        Faculty fac = new Faculty(1L, "Name", "Color");
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:"+port+"/faculty", fac, Faculty.class))
                .isNotNull();
    }

    @Test
    void update() {
        Faculty fac = new Faculty(1L, "Name", "Color");

        ResponseEntity<Faculty> facultyResponseEntity = restTemplate.exchange(
                "http://localhost:"+port+"/faculty",
                HttpMethod.PUT,
                new HttpEntity<>(fac),
                Faculty.class);

        Assertions.assertThat(facultyResponseEntity).isNotNull();
    }

    @Test
    void delete() {
        Faculty fac = new Faculty(1L, "Name", "Color");

        ResponseEntity<Faculty> facultyResponseEntity = restTemplate.exchange(
                "http://localhost:"+port+"/faculty",
                HttpMethod.DELETE,
                new HttpEntity<>(fac),
                Faculty.class);

        Assertions.assertThat(facultyResponseEntity).isNotNull();
    }

    @Test
    void get() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty", Faculty.class))
                .isNotNull();
    }

    @Test
    void getByColor() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty/by-color?color=red", String.class))
                .isNotNull();
    }

    @Test
    void getByName() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty/by-name?name=Name", String.class))
                .isNotNull();
    }

    @Test
    void getAll() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty/all", String.class))
                .isNotNull();
    }

    @Test
    void getAllStudentsFromFaculty() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty/students?id=1", String.class))
                .isNotNull();
    }
}