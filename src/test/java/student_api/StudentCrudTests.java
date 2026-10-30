
package student_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import student_api.model.Student;
import student_api.repository.StudentRepository;
import student_api.service.StudentService;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@Transactional
class StudentCrudTests {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentRepository repository;

    @Test
    void testStudentCRUD() {

        // CREATE
        Student student = new Student(
                "Anuar Akhmet",
                "anuar@example.com"
        );

        Student saved = service.createStudent(student);

        assertNotNull(saved.getId());

        // READ ALL
        assertTrue(service.getAllStudents()
                .stream()
                .anyMatch(s -> s.getId().equals(saved.getId())));

        // READ BY ID
        Student found = service.getStudentById(saved.getId());

        assertEquals("Anuar Akhmet", found.getName());

        // UPDATE
        Student updated = new Student(
                "Anuar Akhmet Updated",
                "updated@example.com"
        );

        Student result = service.updateStudent(
                saved.getId(), updated
        );

        assertEquals("Anuar Akhmet Updated", result.getName());

        // DELETE
        service.deleteStudent(saved.getId());

        assertFalse(repository.existsById(saved.getId()));

        // NOT FOUND
        assertThrows(
                ResponseStatusException.class,
                () -> service.getStudentById(saved.getId())
        );
    }
}
