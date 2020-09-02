package usermanagement.dao;
import student.model.Student;

import java.util.List;

public class TestHibernate {

    public static void main (String[] args) {

        try {
            System.out.println("======================================================>  ");
            StudentDao db = new StudentDao();
            List<Student> students = db.selectStudents();
            System.out.println("++++++++++++++++++++" + students);
            for (Student s: students) {
                System.out.println(s);
                System.out.println("=====");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
// Session session = HibernateHelper.getSessionFactory().getCurrentSession();