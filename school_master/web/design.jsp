<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="static/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
</head>
<script type="text/javascript">
    function delPassage(pid){
        var isDel = confirm("您确认要删除吗？");
        if(isDel){
            //要删除
            location.href = "${pageContext.request.contextPath}/delStudent?sno="+pid;
        }
    }
</script>
<body>
   <jsp:include page="/head.jsp"></jsp:include>
    <!--/sidebar-->
   <jsp:include page="/sidebar.jsp"></jsp:include>
        <div class="result-wrap">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.jsp"><i class="icon-font"></i>添加学生</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>院系</th>
                            <th>班级</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${students.list}" var="student">
                            <tr>
                                <td>${student.sno}</td>
                                <td>${student.sname}</td>
                                <td>${student.ssex}</td>
                                <td>${student.sdept}</td>
                                <td>${student.sclass}</td>
                                <td>
                                    <a class="link-update" href="${pageContext.request.contextPath }/beforEdit?sno=${student.sno}">修改</a><%--先查询passage
                                     然后将数据返回到eidt.jsp//改好的数据更新到数据库  然后再返回到design.jsp--%>
                                    <a class="link-del" onclick="delPassage('${student.sno}')">删除</a>
                                    <a class="link-del" href="${pageContext.request.contextPath }/beforeinsertGrade?sno=${student.sno}">添加成绩</a>
                                    <a class="link-del" href="${pageContext.request.contextPath }/getGrade?sno=${student.sno}">查询成绩</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div style="width: 380px; margin: 0 auto; margin-top: 10px;">
                        <ul class="pagination" style="text-align: center; margin-top: 5px;">
                            <!-- 上一页 -->
                            <!-- 判断当前页是否是第一页 -->
                            <c:if test="${students.currentPage==1}">
                                <li class="disabled">
                                    <a href="javascript:void(0);" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${students.currentPage!=1 }">
                                <li>
                                    <a href="${pageContext.request.contextPath }/getPassageList?currentPage=${students.currentPage-1}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${students.totalPage }" var="page">
                                <!-- 判断当前页 -->
                                <c:if test="${students.currentPage==page }">
                                    <li class="active"><a href="javascript:void(0);">${page}</a></li>
                                </c:if>
                                <c:if test="${students.currentPage!=page }">
                                    <li><a href="${pageContext.request.contextPath }/getPassageList?currentPage=${page}">${page}</a></li>
                                </c:if>
                            </c:forEach>
                            <!-- 判断当前页是否是最后一页 -->
                            <c:if test="${passageList.currentPage==passageList.totalPage }">
                                <li class="disabled">
                                    <a href="javascript:void(0);" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${passageList.currentPage!=passageList.totalPage }">
                                <li>
                                    <a href="${pageContext.request.contextPath }/getPassageList?currentPage=${passageList.currentPage+1}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
