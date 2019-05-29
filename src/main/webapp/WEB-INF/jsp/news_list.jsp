<%--
  Created by IntelliJ IDEA.
  User: Leezhenhao
  Date: 2019/05/28
  Time: 20:01:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>新闻页面</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
</head>
<body>

<br/>
<div class="row clearfix">
    <div class="col-md-12 column">
        <h1 class="text-center">
            新闻列表
        </h1>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal" id="form" action="${pageContext.request.contextPath}/news/list" method="get">
                <input type="hidden" id="cp" name="page" value="1" />
                <input type="hidden" name="size" value="2" />
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="title">新闻标题</label>
                    <div class="col-sm-10">
                        <input class="form-control" id="title" name="title" value="${title}" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-default" type="submit">查询</button>
                    </div>
                </div>
            </form>

            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>新闻编号</th>
                    <th>新闻标题</th>
                    <th>新闻摘要</th>
                    <th>作者</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${pageInfo.list}" var="newsDetail">
                    <tbody>
                    <tr>
                        <td>${newsDetail.id}</td>
                        <td>${newsDetail.title}</td>
                        <td>${newsDetail.summary}</td>
                        <td>${newsDetail.author}</td>
                        <td><fmt:formatDate value="${newsDetail.createDate}" pattern="yyyy-MM-dd" /></td>
                        <td>
                            <button onclick="location.href='${pageContext.request.contextPath}/comment/list/${newsDetail.id}'">查看评论</button>
                            <button onclick="location.href='${pageContext.request.contextPath}/comment/add?newsId=${newsDetail.id}'">添加评论</button>
                            <button onclick="del(this,${newsDetail.id})">删除新闻</button>

                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <div id="page">
                <span style="font-size: 20px;">当前第 ${pageInfo.page} 页 / 共 ${pageInfo.pages} 页  (${pageInfo.count}条)</span>
                <div style="float: right;">
                    <c:if test="${pageInfo.page > 1}">
                        <button class="btn btn-warning" onclick="page(1)">首页</button>
                        <button class="btn btn-warning" onclick="page(${pageInfo.page - 1})">上一页</button>
                    </c:if>
                    <c:if test="${pageInfo.page < pageInfo.pages}">
                        <button class="btn btn-warning" onclick="page(${pageInfo.page + 1})">下一页</button>
                        <button class="btn btn-warning" onclick="page(${pageInfo.pages})">尾页</button>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    // 分页显示
    function page(page){
        //1. 选中隐藏域page,重新赋值.
        $("#cp").val(page);
        //2. 选中form表单提交.
        $("#form").submit();
    }
    
    
    //删除新闻
    function del(obj,id) {
        
        if (confirm("您是否删除编号为:"+id+"的新闻?")){
            
            $.ajax({
                url:"${pageContext.request.contextPath}/news/delete/"+id,
                type:"DELETE",
                dataType:"text",
                success:function (result) {
                    if (result){
                        $(obj).parent().parent().remove();
                    } else {
                        alert("系统正忙,删除失败!!!")
                    }
                },
                error:function (result) {
                    alert("系统正忙,稍后再试!!!")
                }

                
                
                
            });
            
            
        }
        
    }
    
</script>
