<%--
  Created by IntelliJ IDEA.
  User: mr-d9
  Date: 2018/11/25
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加商品</title>
</head>
<body>
<form action="/addProductServlet">
    <ul>
        <li><input type="text"name="shop_id" placeholder="商品ID"></li>
        <li><input type="text"name="shop_name"placeholder="商品名称"></li>
        <li><input type="text"name="shop_img"placeholder="商品图片"></li>
        <li><input type="text"name="shop_des"placeholder="商品介绍"></li>
        <li><input type="text"name="shop_price"placeholder="商品价格"></li>
        <li><input type="submit"name="提交"></li>
    </ul>
</form>
</body>
</html>