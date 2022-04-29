
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="main-wrap">

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

</html>

