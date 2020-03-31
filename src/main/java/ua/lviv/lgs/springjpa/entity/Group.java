package ua.lviv.lgs.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity(name = "Group")
@Table(name = "tb_group")
public class Group {

    @Id
    @GeneratedValue
    @Column
    Integer groupId;

    @Column(nullable = false)
    String name;

    int totalStudents;

    @ManyToMany
    @JoinTable(
            name = "group_student",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    Set<Student> students = new HashSet<>();

}
