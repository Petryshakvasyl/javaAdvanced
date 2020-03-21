package ua.lviv.lgs.onetoone;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")

@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    private FinancialOperation financialOperation;
}
