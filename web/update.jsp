<%--
  Created by IntelliJ IDEA.
  User: mr-d9
  Date: 2018/11/26
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改界面</title>
</head>
<body>
<form action="UpdateServlet" method="post">
        商品ID：<input type="text" value="${shop.shop_id}" readonly="readonly"name="id"/>
        <br/>
        商品名称：<input type="text" value="${shop.shop_name}"name="name"/>
        <br/>
        商品图片：<input type="text" value="${shop.shop_img}"name="img"/>
        <br/>
        商品介绍：<input type="text" value="${shop.shop_des}"name="des"/>
        <br/>
        商品价格：<input type="text" value="${shop.shop_price}"name="price"/>
        <br/>
        <input type="submit" value="确认修改">
</form>
</body>
</html>
