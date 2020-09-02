package school.model;

import student.model.student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school")
public class school {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<student> students = new ArrayList<student>();

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

    @Column
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column
    private String email;

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
