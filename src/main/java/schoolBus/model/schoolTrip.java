package schoolBus.model;

import javax.persistence.*;

@Entity
@Table(name = "SchoolTrip")
public class schoolTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private schoolBus bus;
}
