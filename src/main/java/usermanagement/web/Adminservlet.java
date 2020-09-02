package usermanagement.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet("/admin-Login")
public class Adminservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            try
            {
                if(username!=null)
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","root","");
                    Statement stmt = conn.createStatement();
                    String Query = "select * from Admin where username = '"+username+"' and password = '"+password+"'";
                    ResultSet rs = stmt.executeQuery(Query);
                    if(rs.next())
                    {
                        HttpSession session = request.getSession(true);
                        //Object us = username;
                        session.setAttribute("us", username);
                        String Query2 = "select adminid from Admin where username = '"+username+"'";
                        rs = stmt.executeQuery(Query2);
                        rs.next();
                        String role = rs.getString("adminid");
//                        System.out.println("+++++++++++++++++++++++++" + role);
                        if(role.equals("1"))
                        {
                            response.sendRedirect("/index.html");
                        }

                       // response.sendRedirect("Employees.jsp");
                        //out.println(userId);

                    }
                    else
                    {
                        out.println("Login Failed..Please try again");
                    }
                }

            }
            catch(Exception ex)
            {
                out.println("Exception :"+ex.getMessage());
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher req = request.getRequestDispatcher("/index.html");
        req.include(request, response);
    }

}