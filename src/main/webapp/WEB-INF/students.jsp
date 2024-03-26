<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resourses/css/student_list.css">
<script type="text/javascript" src="../resourses/js/functions.js?v=1"></script>
    <title>Students_List</title>
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

    <form action="/student-create" method="get">
    <input  type="submit" class="button_admin_visibility" value="Создать студента"/>
    </form>
    <input  onclick= "studentDelete()" type="submit" class="button_admin_visibility" value=" Удалить выбранных студентов"/>

</div>
<div id="main">
    <input  onclick= "studentProgress()" type="submit" class="button_admin_visibility" value=" Посмотреть успеваемость выбранного студента"/>

    <input  onclick= "studentModify()" type="submit" class="button_admin_visibility" value=" Модифицировать выбранного студента"/>
</div>
<div id="footer">

    <table class="students_list">
        <caption>Список студентов</caption>
        <thead>
        <tr>
            <th class="head_row"></th>
            <th class="head_row">Фамилия</th>
            <th class="head_row">Имя</th>
            <th class="head_row">Группа</th>
            <th class="head_row">Дата поступления</th>
        </tr>
        </thead>

        <c:forEach items="${students}" var="st">
        <tbody>
        <tr>
            <td><input class="checkbox" type="checkbox" id="" value="${st.id}"></td>
            <td>${st.surname}</td>
            <td>${st.name}</td>
            <td>${st.groupe}</td>
            <td><fmt:formatDate value="${st.date}" pattern="dd/MM/yyyy"/></td>
        </tr>

        </tbody>
        </c:forEach>
    </table>

</div>


<form action="/student-modify" method="get" id="formToModify">
    <input type="hidden" name="hiddenModifyId" id="hiddenModifyId">

</form>

<form action="/student-delete" method="get" id="formToDelete">
    <input type="hidden" name="hiddenIdsToDelete" id="hiddenIdsToDelete">

</form>

<form action="/student-progress" method="get" id="formToProgress">
    <input type="hidden" name="hiddenIdToProgress" id="hiddenIdToProgress">

</form>

</body>

</html>