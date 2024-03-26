<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resourses/css/style_progress.css">

    <title>Students_Progress</title>
</head>

<body>
<nav>
    <a href="../Logout/index_logout.html" target="_blank" class="logout">Logout</a>
</nav>
<div id="header">
    <h1>Система управления студентами и их успеваемостью </h1>
</div>
<div id="leftSidebar">
    <a href="../Title_page/index.html" class="to_main">На главную</a>
</div>
<div id="rightSidebar">

    <table class="students_list">
        <caption>Отображена успеваемость для следующего студента: </caption>
        <thead>
        <tr>

            <th class="head_row">Фамилия</th>
            <th class="head_row">Имя</th>
            <th class="head_row">Группа</th>
            <th class="head_row">Дата поступления</th>
        </tr>
        </thead>
        <tbody>
        <tr>

            <td>${student.surname}</td>
            <td>${student.name}</td>
            <td>${student.groupe}</td>
            <td><fmt:formatDate value="${student.date}" pattern="dd/MM/yyyy"/></td>
        </tr>
        </tbody>
    </table>
</div>

<div id="main"><a href="../Students/index_st_list.html" class="to_main">Назад</a></div>


<div id="leftSidebar_footer">

    <table class="discipline_mark_list">

        <thead>
        <tr>
            <th class="head_row">Дисциплина</th>
            <th class="head_row">Оценка</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${marks}" var="m">

                <tr>
            <td>${m.discipline.discipline}</td>
            <td>${m.mark}</td>
        </tr>

        </tbody>
        </c:forEach>
    </table>
    <br>
</div>

<div id="rightSidebar_footer">
    <form method="get">

        <label for="semester">Выбрать семестр </label>
        <select id="semester" name="select_sem">
            <option value="semester 1">Cеместр 1</option>
            <option value="semester 2">Cеместр 2</option>

        </select>

        <button type="submit" class="button_progress">Выбрать</button>
        <!-- <input type="submit" value="Выбрать" /> -->

    </form>
    <div class="average_mark">
        <p>Средняя оценка за семестр: 4.8 балла</p>
    </div>

</body>

</html>
