package ru.hogwarts.school.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.repo.FacultyRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {
    private Faculty faculty;
    private FacultyService facultyService;
    @Mock
    private FacultyRepository facultyRepositoryMock;

    @BeforeEach
    void setUp() {
        facultyService = new FacultyService(facultyRepositoryMock);
        faculty = new Faculty(1L,"A", "green");
    }

    @Test
    void add() {
        facultyService.add(faculty);
        Mockito.verify(facultyRepositoryMock, Mockito.times(1)).add(Mockito.any());
    }

    @Test
    void update() {
        facultyService.update(faculty);
        Mockito.verify(facultyRepositoryMock, Mockito.times(1)).update(Mockito.any());
    }

    @Test
    void delete() {
        facultyService.delete(faculty.getId());
        Mockito.verify(facultyRepositoryMock, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void get() {
        Faculty expected = faculty;

        Mockito.doReturn(expected).when(facultyRepositoryMock).get(Mockito.any());
        Assertions.assertEquals(expected, facultyService.get(faculty.getId()));
    }

    @Test
    void getByColor() {
        List<Faculty> expected = new ArrayList<>();
        expected.add(faculty);
        expected.add(faculty);

        Mockito.doReturn(expected).when(facultyRepositoryMock).getByColor(Mockito.anyString());
        Assertions.assertEquals(expected, facultyService.getByColor(faculty.getColor()));
    }

    @Test
    void getAll() {
        Map<Long, Faculty> expected = new HashMap<>();
        expected.put(faculty.getId(), faculty);

        Mockito.doReturn(expected).when(facultyRepositoryMock).getAll();
        Assertions.assertEquals(expected, facultyService.getAll());
    }
}