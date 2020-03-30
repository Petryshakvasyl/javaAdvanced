package ua.lviv.lgs.springjpa.service;

import ua.lviv.lgs.springjpa.entity.Group;
import ua.lviv.lgs.springjpa.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GroupService {

    Group create(Group group);

    Optional<Group> findById(Integer id);

    List<Group> findAll();

    void deleteById(Integer id);

    Group update(Group student);

    void addStudentToGroup(Integer studentId, Integer groupId);

    Set<Student> findStudentsInGroup(Integer groupId);
}
