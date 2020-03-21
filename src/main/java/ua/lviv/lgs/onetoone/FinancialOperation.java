package ua.lviv.lgs.onetoone;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data

@Entity
@Table(name = "financial_operation")
public class FinancialOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer amount;

    private LocalDate date;

    @OneToOne(mappedBy = "financialOperation")
    private Customer customer;

}
