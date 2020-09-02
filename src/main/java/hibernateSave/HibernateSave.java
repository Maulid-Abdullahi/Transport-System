package hibernateSave;

import org.hibernate.Session;
import org.hibernate.Transaction;
import school.model.School;
import student.model.Student;
import usermanagement.utl.HibernateUtil;


public class HibernateSave {

    public static void main(String args []){
        //deleteStudent();
        //listStudentFromSchool();
        //saveStudentUsingSchool();
        saveStudent();
        //listStudents();
        //insertWithPersistMethod();
        //insertWithSaveOrUpdateMethod();
        //updateWithUpdateMethod();
        //insertWithMergeMethod();
        /*retrieveUsingIdWithGetMethod();
        System.out.println("****************************************************");
        System.out.println();
        System.out.println();
        System.out.println();
        retrieveUsingIdWithLoadMethod();*/

        //retrieveData();
    }

    //1. methods for saving and updating...
    public static void saveStudent(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = session.getTransaction();
        tx.begin();

        School school = new School();
        school.setName("Tracom4 Academy");
        school.setEmail("tracom4@gmail.com");

        int schoolId = (Integer) session.save(school);

        Student student = new Student();


        student.setSchool(session.load(School.class, schoolId));
        student.setSchool(school);

        student.setName("Maulid4");
        student.setRegNo("23233223232334");
        student.setRegNo("PR/2020/7884524");
        student.setSkul("Tracom4 Academy");
        session.save(student);

        tx.commit();
    }

//    //1. methods for saving and updating...
//    public static void saveStudentUsingSchool(){
//        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
//
//        Transaction tx = session.getTransaction();
//        tx.begin();
//
//        School school = new School();
//        school.setName("HAVARD - Rwanda");
//        school.setContact(new Contact());
//        school.getContact().setEmail("harvard.rw@tracom.com");
//
//        //int schoolId = (Integer) session.save(school);
//
//        for (int idx = 0; idx<1000; idx++) {
//            Student student = new Student();
//            student.setPerson(new Person());
//
//            //student.setSchool(session.load(School.class, schoolId));
//            student.setSchool(school);
//
//            student.getPerson().setName("Alexd" + idx);
//            student.getPerson().setGender(Gender.FEMALE);
//            student.getPerson().setIdNo("232332232323dd" + idx);
//            student.getPerson().setMaritalStatus(MaritalStatus.COMPLICATED);
//            student.getPerson().setReligion(Religion.CHRISTIAN);
//
//            student.setContact(new Contact());
//            student.getContact().setEmail("alexd@tracom.com" + idx);
//
//            student.setRegNo("PR/2020/78845d" + idx);
//            student.setNameOfChief("Kiaried" + idx);
//            student.setSecondarySkul("Tumainid Industry Secondary School" + idx);
//
//            //******
//            school.addStudent(student);
//        }
//
//        session.save(school);
//
//        tx.commit();
//    }
//

//    public static void listStudentFromSchool() {
//        Session session = HibernateHelper.getSessionFactory().openSession();
//
//        List<School> schools = session.createQuery("FROM School s").getResultList();
//
//        for (School school : schools) {
//            System.out.println(school.getName().toUpperCase());
//            System.out.println("Students are as follows:");
//
//            for (Student student : school.getStudents())
//                System.out.println(student.getId() + ". " + student.getPerson().getName() + " emails is " + student.getContact().getEmail());
//
//
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            System.out.println();
//            System.out.println();
//            System.out.println();
//
//        }
    }


