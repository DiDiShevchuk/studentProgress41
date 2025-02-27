package controllers;

import db.DBManager;

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


@WebServlet (name="StudentCreateController", urlPatterns="/student-create")
public class StudentCreateController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String surname = req.getParameter("last-name");
        String name = req.getParameter("first-name");
        String group = req.getParameter("group");
        String date = req.getParameter("admission-date");

        surname = surname.replaceAll(" ","");
        name = name.replaceAll(" ","");
        group = group.replaceAll(" ","");
        date = date.replaceAll(" ","");

        if(surname == null || name == null || group == null || date == null
                ||surname.isEmpty() || name.isEmpty() || group.isEmpty() || date.isEmpty()){
            req.setAttribute("message", "1"); // русский текст не пишем, просто устанавливаем символ, а на jsp передаем сигнал для отпарвки текст
            req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);
            return;
        }


        //пришло от пользователя 30/04/2024 --> 2024-04-30 для БД
       // String --> Date -->  String

        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        Date dateObj = null;
        try {
            dateObj = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToDatabase = formatter.format(dateObj);  //

        DBManager.createStudent(surname, name, group, dateToDatabase);

        resp.sendRedirect("/students");
    }
}
