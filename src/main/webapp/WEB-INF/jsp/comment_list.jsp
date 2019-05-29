
<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/05/29
  Time: 7:43:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>新闻评论页面</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h1 class="text-center">
                        新闻评论列表
                    </h1>
                </div>
            </div>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>评论编号</th>
                    <th>评论内容</th>
                    <th>评论人</th>
                    <th>评论时间</th>
                </tr>
                </thead>
                <c:forEach items="${newsCommentList}" var="newsComment">
                    <tbody>
                    <tr>
                        <td>${newsComment.id}</td>
                        <td>${newsComment.content}</td>
                        <td>${newsComment.author}</td>
                        <td><fmt:formatDate value="${newsComment.createDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    </tbody>
                </c:forEach>
                <tr>
                    <th colspan="4" c>
                        <button onclick="location.href='${pageContext.request.contextPath}/news/list'">返回新闻列表</button>
                    </th>
                </tr>
            </table>


        </div>
    </div>
</div>
</body>
</html>

