package com.student.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.student.dao.StudentDao;
import com.student.model.Student;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Student st = new Student();
        st.setId(id);
        st.setName(name);
        st.setEmail(email);

        StudentDao dao = new StudentDao();
        dao.saveStudent(st);

        response.sendRedirect("display.jsp");
    }
}
