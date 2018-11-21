<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.pojos.Shops" %><%--
  Created by IntelliJ IDEA.
  User: mr-d9
  Date: 2018/11/21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品信息页面</title>
</head>
<body>
<table>
    <%
        Object shops = request.getAttribute("shops");
        if (shops instanceof List)
        {
            List<Shops> lists = (List<Shops>)shops;
            for (Shops s:lists) {
    %>
    <tr>
        <td><%=s.getShop_id()%></td>
        <td><%=s.getShop_name()%></td>
        <td><<img src="http://localhost:8080/photo/<%=s.getShop_img()%>"></td>
        <td><%=s.getShop_des()%></td>
        <td><%=s.getShop_price()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
