package schoolBus.model;

import student.model.student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "StudentTrip")
public class studentInTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private schoolTrip schoolTrip;

   @OneToMany(mappedBy = "studentInTrip")
   private List<student> stud = new ArrayList<>();

}
