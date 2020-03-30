package ua.lviv.lgs.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.springjpa.entity.Group;
import ua.lviv.lgs.springjpa.entity.Student;
import ua.lviv.lgs.springjpa.exceptions.NotFoundException;
import ua.lviv.lgs.springjpa.service.GroupService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> findAll() {
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    public Group findById(@PathVariable Integer id) {
        return groupService.findById(id).orElseThrow(() -> new NotFoundException("group with id " + id + " not found"));
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.create(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        groupService.deleteById(id);
    }

    @PostMapping("/{groupId}/students/{studentId}")
    public void addStudentToGroup(@PathVariable Integer studentId, @PathVariable Integer groupId) {
        groupService.addStudentToGroup(studentId, groupId);
    }

    // /api/groups/id/students
    @GetMapping("/{groupId}/students")
    public Set<Student> findStudentsInGroup(@PathVariable Integer groupId) {
        return groupService.findStudentsInGroup(groupId);
    }

}
