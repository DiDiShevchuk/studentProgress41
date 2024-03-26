<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="../resourses/css/style_st_create.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <title>Student_creating</title>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy' });
        } );
    </script>
</head>
<body>
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
    <div>
        <p>Для создания студента заполните все поля и нажмите кнопку "Создать".</p>

        <form action="/student-create" method="post" class="std-mod-form">

            <label for="last-name">Фамилия </label><input id="last-name" name="last-name" type="text">
            <label for="name">Имя </label><input id="name" name="first-name" type="text">
            <label for="group">Группа </label><input id="group" name="group" type="text">
            <label for="datepicker">Дата поступления </label><input id="datepicker" name="admission-date" type="text">
            <div class="row">
            <input class="button" type="submit" value="Создать">
            </div>

            <c:if test="${message eq 1}">
            <h4>
                Поля не должны быть пустыми
            </h4>
            </c:if>
        </form>

    </div>
</div>
<div id="main"><a href="../Students/index_students.html" class="to_main">Назад</a></div>

</body>
</body>
</html>