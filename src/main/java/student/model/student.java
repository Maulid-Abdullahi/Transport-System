package student.model;

import school.model.school;
import schoolBus.model.studentInTrip;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class student {

    private int id;

    private String name;

    private String regNo;


    @ManyToOne
    private school school;

    @ManyToOne
    private studentInTrip studentInTrip;

    public studentInTrip getStudentInTrip() {
        return studentInTrip;
    }

    public void setStudentInTrip(schoolBus.model.studentInTrip studentInTrip) {
        this.studentInTrip = studentInTrip;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public school getSchool() {
        return school;
    }

    public void setSchool(school school) {
        this.school = school;
    }
}



