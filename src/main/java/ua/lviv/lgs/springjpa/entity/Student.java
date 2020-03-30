package ua.lviv.lgs.springjpa.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Min(1)
    @Max(6)
    @Column(nullable = false)
    private int course;


}
