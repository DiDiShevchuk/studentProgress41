package controllers;

import db.DBManager;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 - достаем студента по id (придет с запросом)
        // 2 - достаем активные семестры для выпадающего списка (кнопка выбрать семестр)
        // 3 - определить какой семестр сейчас выбран (если мы перешли с главной страницы, то выбранным яв-ся
        // ПЕРВЫЙ из этого списка)
        // (если мы нажали на кнопку "ВЫБРАТЬ" - тогда мы должны ожидать id выбранного семестра)
        // 4 -  вытягиваем оценки относительно выбранного семестра
        // 5 - посчитать средний балл (из массива, 4 пункта)

        // все эти данные отправить на jsp в виде атриббутов


        String idStud = req.getParameter("hiddenIdToProgress");
        Student student = DBManager.getStudentById(idStud);
        req.setAttribute("student", student); // 1 - достали студента по id (придет с запросом)

        List<Term> terms = DBManager.getAllActiveTerms(); // 2 - достаем активные семестры для выпадающего списка (кнопка выбрать семестр)
        req.setAttribute("terms", terms);

        // 3 - определить какой семестр сейчас выбран (если мы перешли с главной страницы, то выбранным яв-ся
        // Если был переход из страницы "Все студенты" - тогда выбранный первый из terms
        // Если был переход из кнопки "Выбрать семестр" в Student Progress, тогда нам должны передать id выбранного

        Term selectedTerm = null;
        // нам передали id  выбранного?
        if(req.getParameter("idSelectedTerm") != null){
            // вытягивать с базы term семестр по id
            selectedTerm = DBManager.getTermById(req.getParameter("idSelectedTerm"));
        }else {
            // если не передали, то вытягивать всех активных  первого
            selectedTerm = terms.get(0);
        }

        req.setAttribute("selectedTerm", selectedTerm);

        // 4 -  вытягиваем оценки относительно выбранного семестра
        List<Mark> marks = DBManager.getMarksByStudentAndTerm(idStud, selectedTerm.getId());

        // 5 - посчитать средний балл (из массива, 4 пункта)
        double sumMarks = 0;
        for(Mark m : marks){
            sumMarks = sumMarks + m.getMark();
        }

        double avarage = sumMarks / marks.size();
        req.setAttribute("avarage", avarage);

        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);
    }
}
