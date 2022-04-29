<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">

        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="login.jsp">登录</a></li>
            </ul>login.jsp
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>教务系统</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath }/getstudent"><i class="icon-font">&#xe008;</i>学生信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

</html>
