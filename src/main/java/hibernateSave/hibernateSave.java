package hibernateSave;

import hibernateHelper.hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import school.model.school;
import student.model.student;

import java.util.List;

public class hibernateSave {

    public static void main(String args[]) {
        // deleteStudent();
        saveStudent();
        //listStudents();

    }

    //1. methods for saving and updating...
    public static void saveStudent() {
        Session session = hibernate.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        school schools = new school();
        schools.setId(1);
        schools.setName("Tracom Academy");
        schools.setEmail("maulidabdullahi3@tracom.com");
        schools.setPhoneNo("0720304574");



        int schoolId = (Integer) session.save(schools);


        student students = new student();
        students.setId(1);
        students.setName("Maulid abdullahi");
        students.setRegNo("9090");

        students.setSchool(session.load(school.class, schoolId));
        schools.getStudents().add(students);
        session.save(students);
        tx.commit();
    }

    //1. delete student..
    public static void deleteStudent() {
        Session session = hibernate.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

//        Student student = session.load(Student.class, 6);

//        session.delete(student);

        tx.commit();
    }


    public static void listStudents() {
        Session session = hibernate.getSessionFactory().openSession();

        List<student> students = session.createQuery("FROM students s").getResultList();

        for (student student : students) {

            System.out.println(student.getId() + ". " + student.getName() + " emails is " + student.getRegNo());

            if (student.getSchool() != null)
                System.out.println(student.getSchool());

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}