<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学员</title>
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
    <style media="screen">
        .table{text-align: center;}
    </style>
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>
<!--/sidebar-->
<jsp:include page="/sidebar.jsp"></jsp:include>
<form action="${pageContext.request.contextPath }/updateStudent">
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
            <td><input type="text" name="sno" value="${student.sno}"/></td>
            <td><input type="text" name="sname" value="${student.sname}"/></td>
            <td><input type="text" name="ssex" value="${student.ssex}"/></td>
            <td><input type="text" name="sage" value="${student.sage}"/></td>
            <td><input type="text" name="sdept" value="${student.sdept}"/></td>
            <td><input type="text" name="sclass" value="${student.sclass}"/></td>
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

