package ua.lviv.lgs.springjpa.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.lviv.lgs.springjpa.entity.Student;
import ua.lviv.lgs.springjpa.repository.StudentRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        Student student = new Student();
        student.setCourse(1);
        student.setFirstName("Ivan");
        student.setLastName("Kirenko");

        studentService.create(student);

        Iterable<Student> actualStudents = studentRepository.findAll();
        assertThat(actualStudents).hasSize(1);
        Student actualStudent = actualStudents.iterator().next();
        assertThat(actualStudent.getId()).isNotNull();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }
}