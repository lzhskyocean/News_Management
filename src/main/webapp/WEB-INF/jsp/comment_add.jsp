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

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>


<form action="${pageContext.request.contextPath}/comment/add" method="post">

    <input type="hidden" name="newsId" value="${newsId}">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h1 class="text-center">
                    添加新闻评论
                </h1>
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>评论内容(*)</th>
                        <td>
                            <textarea name="content" cols="165" rows="5"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>评论人</th>
                        <td>
                            <input type="text" name="author" width="1000px">
                        </td>
                    </tr>
                    </thead>
                    <tr>
                        <th colspan="2">
                            <button type="submit" class="btn btn-default btn-primary">提交</button>

                            <button type="button" class="btn btn-default btn-primary"
                                    onclick="location.href='${pageContext.request.contextPath}/news/list'"
                            >返回新闻列表</button>
                        </th>
                    </tr>

                </table>
            </div>
        </div>
    </div>

</form>



</body>
</html>

