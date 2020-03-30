package ua.lviv.lgs.springjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
public class Media {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String type;

    @Lob
    private byte[] data;

}
