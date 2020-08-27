package schoolBus.model;

import student.model.student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "StudentInTrip")
public class studentInTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


   @OneToMany(mappedBy = "studentInTrip", cascade = CascadeType.ALL)
   private List<student> stud = new ArrayList<>();

    @ManyToOne
    private commuteTrip commuteTrips;

    public commuteTrip getCommuteTrips() {
        return commuteTrips;
    }

    public void setCommuteTrips(commuteTrip commuteTrips) {
        this.commuteTrips = commuteTrips;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<student> getStud() {
        return stud;
    }

    public void setStud(List<student> stud) {
        this.stud = stud;
    }
}
