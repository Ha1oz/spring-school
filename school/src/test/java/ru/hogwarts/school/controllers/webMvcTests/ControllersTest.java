package ru.hogwarts.school.controllers.webMvcTests;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.controllers.AvatarController;
import ru.hogwarts.school.controllers.FacultyController;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repositories.AvatarRepository;
import ru.hogwarts.school.repositories.FacultyRepository;
import ru.hogwarts.school.repositories.StudentRepository;
import ru.hogwarts.school.services.AvatarService;
import ru.hogwarts.school.services.FacultyService;
import ru.hogwarts.school.services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ControllersTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FacultyRepository facultyRepository;
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private AvatarRepository avatarRepository;

    @SpyBean
    private FacultyService facultyService;
    @SpyBean
    private StudentService studentService;
    @SpyBean
    private AvatarService avatarService;

    @InjectMocks
    private FacultyController facultyController;
    @InjectMocks
    private FacultyController studentController;
    @InjectMocks
    private AvatarController avatarController;


    @Test
    void addAndFindFaculty() throws Exception {
        Long id = 1L;
        String name = "Name";
        String color = "Color";

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);

        Faculty fac = new Faculty(id, name, color);

        Mockito.when(facultyRepository.save(Mockito.any(Faculty.class))).thenReturn(fac);
        Mockito.when(facultyRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(fac));

        mockMvc.perform(MockMvcRequestBuilders
                .post("/faculty")
                .content(facultyObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    void getByColorFaculty() throws Exception {
        Long id = 1L;
        String name = "Name";
        String color = "Color";

        Faculty fac = new Faculty(id, name, color);
        List<Faculty> resultList = new ArrayList<Faculty>();
        resultList.add(fac);

        Mockito.when(facultyRepository.findByColor(Mockito.any(String.class))).thenReturn(resultList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/by-color?color=color")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getByNameFaculty() throws Exception {
        Long id = 1L;
        String name = "Name";
        String color = "Color";

        Faculty fac = new Faculty(id, name, color);
        List<Faculty> resultList = new ArrayList<Faculty>();
        resultList.add(fac);

        Mockito.when(facultyRepository.findByColor(Mockito.any(String.class))).thenReturn(resultList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/by-name?name=name")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllFaculties() throws Exception {
        Long id = 1L;
        String name = "Name";
        String color = "Color";

        Faculty fac = new Faculty(id, name, color);
        List<Faculty> resultList = new ArrayList<Faculty>();
        resultList.add(fac);

        Mockito.when(facultyRepository.findByColor(Mockito.any(String.class))).thenReturn(resultList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void addAndFindStudent() throws Exception {
        Long id = 1L;
        String name = "Name";
        Integer age = 12;

        JSONObject studentObject = new JSONObject();
        studentObject.put("name", name);
        studentObject.put("age", age);

        Student student = new Student(id, name, age, new Faculty());

        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);
        Mockito.when(studentRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/student")
                        .content(studentObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/student?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    void getByAgeStudent() throws Exception {
        Long id = 1L;
        String name = "Name";
        Integer age = 12;

        Student student = new Student(id, name, age, new Faculty());

        List<Student> resultList = new ArrayList<>();
        resultList.add(student);

        Mockito.when(studentRepository.findByAge(Mockito.any(Integer.class))).thenReturn(resultList);
        Mockito.when(studentRepository.findByAgeBetween(Mockito.any(Integer.class),Mockito.any(Integer.class))).thenReturn(resultList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/by-age?age=12")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/by-age-between?minAge=11&maxAge=14")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void getAllStudents() throws Exception {
        Long id = 1L;
        String name = "Name";
        Integer age = 12;

        Student student = new Student(id, name, age, new Faculty());

        List<Student> resultList = new ArrayList<>();
        resultList.add(student);

        Mockito.when(studentRepository.findAll()).thenReturn(resultList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}