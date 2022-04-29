<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学员</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <style media="screen">
        .table{text-align: center;}
    </style>
</head>
<body>
<jsp:include page="/head.jsp/head.jsp"></jsp:include>
<!--/sidebar-->
<jsp:include page="/sidebar.jsp/sidebar.jsp"></jsp:include>
<form action="/insertGrade">
    <table class="table table-bordered table-hover">
        <tr class="info">
            <td >姓名</td>
            <td>数据库</td>
            <td>编译原理</td>
            <td>高数</td>
            <td>复变函数</td>
            <td>概率论</td>
        </tr>
        <tr>
            <td><input type="text" name="sno" value="${student.sno}"/></td>
            <td><input type="text" name="sjk"/></td>
            <td><input type="text" name="byyl"/></td>
            <td><input type="text" name="gs"/></td>
            <td><input type="text" name="fbhs"/></td>
            <td><input type="text" name="gll"/></td>
        </tr>
        <tr>
            <td colspan="6" class="danger"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
<script src="js/jquery.min.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>

