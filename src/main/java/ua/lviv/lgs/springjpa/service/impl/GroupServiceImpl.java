package ua.lviv.lgs.springjpa.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.springjpa.entity.Group;
import ua.lviv.lgs.springjpa.entity.Student;
import ua.lviv.lgs.springjpa.exceptions.NotFoundException;
import ua.lviv.lgs.springjpa.repository.GroupRepository;
import ua.lviv.lgs.springjpa.service.GroupService;
import ua.lviv.lgs.springjpa.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final StudentService studentService;


    public GroupServiceImpl(GroupRepository groupRepository, StudentService studentService) {
        this.groupRepository = groupRepository;
        this.studentService = studentService;
    }

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Optional<Group> findById(Integer id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group update(Group student) {
        return groupRepository.save(student);
    }

    @Override
    public void addStudentToGroup(Integer studentId, Integer groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NotFoundException("group with id " + groupId + " was not found"));

        Student student = studentService.findById(studentId).orElseThrow(
                () -> new NotFoundException("student with id " + studentId + " was not found"));

        group.getStudents().add(student);
        groupRepository.save(group);
    }

    @Override
    public Set<Student> findStudentsInGroup(Integer groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new NotFoundException("group with id " + groupId + " was not found"))
                .getStudents();
    }
}
