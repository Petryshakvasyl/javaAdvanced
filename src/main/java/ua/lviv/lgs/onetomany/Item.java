package ua.lviv.lgs.onetomany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "fk_card_id")
    @ToString.Exclude
    private Cart cart;
}
