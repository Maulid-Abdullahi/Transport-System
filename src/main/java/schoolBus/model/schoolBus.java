package schoolBus.model;

import javax.persistence.*;

@Entity
@Table(name = "SchoolBus")
public class schoolBus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String busNo;
}
