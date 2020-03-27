package ua.lviv.lgs.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.springjpa.entity.Student;
import ua.lviv.lgs.springjpa.exceptions.BadRequestException;
import ua.lviv.lgs.springjpa.exceptions.NotFoundException;
import ua.lviv.lgs.springjpa.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getAllStudents(@PathVariable Integer id) {
        return studentService.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        if (student.getId() == null) {
            throw new BadRequestException("cannot update student without id");
        }
        return studentService.update(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
    }

}
