package id.co.indivara.jdt12.banklatihan.miniproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "master_costumer")
@Entity
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Account> accounts;

}
