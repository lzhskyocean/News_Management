<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/05/29
  Time: 8:32:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新闻评论页面</title>
</head>
<body>

<div>

    <form action="${pageContext.request.contextPath}/comment/add" method="post">

        <input type="hidden" name="newsId" value="${newsId}">

        <table border="1px" cellspacing="0px">

            <tr>
                <th colspan="2">
                    <h1>增加评论</h1>
                </th>
            </tr>

            <tr>
                <th>评论内容(*)</th>
                <td>
                    <textarea name="content" cols="20"></textarea>
                </td>
            </tr>
            <tr>
                <th>评论人</th>
                <td>
                    <input type="text" name="author">
                </td>
            </tr>


            <tr>
                <th colspan="2">
                    <button>提交</button>
                    <button onclick="location.href='${pageContext.request.contextPath}/news/list'">返回新闻列表</button>
                </th>
            </tr>
        </table>


    </form>


</div>


</body>
</html>

