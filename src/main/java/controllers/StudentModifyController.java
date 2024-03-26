package controllers;

import db.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "StudentModifyController", urlPatterns = "/student-modify")

public class StudentModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStudModify = req.getParameter("hiddenModifyId");
        Student student = DBManager.getStudentById(idStudModify);

        req.setAttribute("student", student); // название сами придумываем, его будем использовать на jsp
        req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String datepicker = req.getParameter("datepicker");
        String idStudToModify = req.getParameter("idStudToModify");

        lastName = lastName.replaceAll(" ","");
        name = name.replaceAll(" ","");
        group = group.replaceAll(" ","");
        datepicker = datepicker.replaceAll(" ","");

        if(lastName == null || name == null || group == null || datepicker == null
                ||lastName.isEmpty() || name.isEmpty() || group.isEmpty() || datepicker.isEmpty()){
            req.setAttribute("message", "1"); // русский текст не пишем, просто устанавливаем символ, а на jsp передаем сигнал для отпарвки текст
            req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req, resp);
            return;
        }


        //пришло от пользователя 30/04/2024 --> 2024-04-30 для БД
        // String --> Date -->  String

        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        Date dateObj = null;
        try {
            dateObj = format.parse(datepicker);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToDatabase = formatter.format(dateObj);  //

        DBManager.modifyStudent(lastName,name, group,dateToDatabase, idStudToModify);

        resp.sendRedirect("/students");
    }

}
