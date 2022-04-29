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
<form action="${pageContext.request.contextPath }/insertStudent">
    <table class="table table-bordered table-hover">
        <tr class="info">
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>院系</td>
            <td>班级</td>
        </tr>
        <tr>
            <td><input type="text" name="sno"/></td>
            <td><input type="text" name="sname"/></td>
            <td><input type="text" name="ssex"/></td>
            <td><input type="text" name="sage"/></td>
            <td><input type="text" name="sdept"/></td>
            <td><input type="text" name="sclass"/></td>
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

