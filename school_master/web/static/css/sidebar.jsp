
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="${pageContext.request.contextPath }/serch" method="post">
                <table class="search-tab">
                    <tr>
                        <th width="100">学生姓名:</th>
                        <td><input class="common-text" placeholder="学生姓名" name="sname" type="text"></td>
                        <td><input class="btn btn-primary btn2" value="查询" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
