package student.model;
import school.model.School;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String regNo;

    @Column(name = "skul")
    private String Skul;

    public Student(String name, String regNo, String school, String skul) {
    }

    public Student(int id, String name, String regNo, String school, String skul) {
    }

    public String getSkul() {
        return Skul;
    }

    public void setSkul(String skul) {
        Skul = skul;
    }

    @ManyToOne
    @JoinColumn(name="school_id")
    private School school;


    public Student() {
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

