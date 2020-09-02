package usermanagement.web;

import student.model.Student;
import usermanagement.dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the student.

 */

@WebServlet("/")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public void init() {

        studentDao = new StudentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showingNewForm(request, response);
                    break;
                case "/insert":
                    insertingStudent(request, response);
                    break;
                case "/delete":
                    deletingStudent(request, response);
                    break;
                case "/edit":
                    showingEditForm(request, response);
                    break;
                case "/update":
                    UpdatingStudent(request, response);
                    break;
                default:
                    getStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void getStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> getStudent = studentDao.selectStudents();
        request.setAttribute("getStudent", getStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showingNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showingEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Student_id"));
        Student existingStudent = studentDao.getStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);

    }

    private void insertingStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String regNo = request.getParameter("regNo");
        String skul = request.getParameter("skul");
        String school = request.getParameter("school");

        Student newStudent=  new Student(name, regNo, skul,  school);
        studentDao.saveStudent(newStudent);
        response.sendRedirect("list");
    }

    private void UpdatingStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("Student_id"));
        String name = request.getParameter("name");
        String regNo = request.getParameter("regNo");
        String skul = request.getParameter("skul");
        String school = request.getParameter("school");


        Student  students =  new Student(id,name, regNo, skul, school);
       studentDao.updateStudent(students);
        response.sendRedirect("list");
    }

    private void deletingStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("Student_id"));
        studentDao.deleteStudent(id);
        response.sendRedirect("list");
    }
}

