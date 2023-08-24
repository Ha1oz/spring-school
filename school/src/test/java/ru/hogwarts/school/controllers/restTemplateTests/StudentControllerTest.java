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
import ru.hogwarts.school.controllers.StudentController;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }
    @Test
    void add() {
        Faculty fac = new Faculty(1L, "Name", "Color");
        Student student = new Student(2L, "Alex", 12, fac);
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:"+port+"/student", student, Student.class))
                .isNotNull();
    }

    @Test
    void update() {
        Faculty fac = new Faculty(1L, "Name", "Color");
        Student student = new Student(2L, "Alex", 12, fac);
        ResponseEntity<Student> studentResponseEntity = restTemplate.exchange(
                "http://localhost:"+port+"/student",
                HttpMethod.PUT,
                new HttpEntity<>(student),
                Student.class);

        Assertions.assertThat(studentResponseEntity).isNotNull();
    }

    @Test
    void delete() {
        Faculty fac = new Faculty(1L, "Name", "Color");
        Student student = new Student(2L, "Alex", 12, fac);
        ResponseEntity<Student> studentResponseEntity = restTemplate.exchange(
                "http://localhost:"+port+"/student",
                HttpMethod.DELETE,
                new HttpEntity<>(student),
                Student.class);

        Assertions.assertThat(studentResponseEntity).isNotNull();
    }

    @Test
    void get() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student", Student.class))
                .isNotNull();
    }

    @Test
    void getByAge() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student/by-age?age=12", String.class))
                .isNotNull();
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student/by-age?minAge=12&maxAge=15", String.class))
                .isNotNull();
    }

    @Test
    void getAll() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student/all", String.class))
                .isNotNull();
    }

    @Test
    void getFacultyFromStudent() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student/faculty?id=2", Faculty.class))
                .isNull();
    }
}