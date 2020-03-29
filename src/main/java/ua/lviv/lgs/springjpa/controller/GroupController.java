package ua.lviv.lgs.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.springjpa.entity.Group;
import ua.lviv.lgs.springjpa.exceptions.NotFoundException;
import ua.lviv.lgs.springjpa.service.GroupService;

import java.util.List;

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
}
