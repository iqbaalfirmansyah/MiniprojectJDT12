package id.co.indivara.jdt12.banklatihan.miniproject.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Table(name = "master_account")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    private String type;
    @Column(name = "balance")
    private BigDecimal balance;


}
