package usermanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import student.model.Student;
import usermanagement.utl.HibernateUtil;
import java.util.List;

/**
 * CRUD database operations
 * @author Maulid
 *
 */
public class StudentDao {

    /**
     * Save Student
     *
     * @param student
     */
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Student
     *
     * @param student
     */
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Student
     *
     * @param Student_id
     */
    public void deleteStudent(int Student_id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Student students = session.get(Student.class, Student_id);
            if (students != null) {
                session.delete(students);
                System.out.println("student is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Student By ID
     *
     * @param Student_id
     * @return
     */
    public Student getStudent(int Student_id) {

        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            student = session.get(Student.class, Student_id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Get all Student
     *
     * @return
     */
    @SuppressWarnings("unchecked")


    public List<Student> selectStudents() {

        List<Student> getStudents = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // get a student object
            getStudents = session.createQuery("FROM  Student s").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return getStudents;
    }
}