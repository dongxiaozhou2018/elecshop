<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.pojos.Shops" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mr-d9
  Date: 2018/11/19
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>主页面</title>
    <link rel="stylesheet" href="../css/shouye.css">
    <link rel="stylesheet" href="../css/productList.css">
    <link rel="stylesheet" href="../css/addproduct.css">
    <link rel="stylesheet" href="../css/deleteproduct.css">
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../js/mainpage.js"></script>
</head>
<body>
<div id="container">
    <!--logo-->
    <div id="title"><div>logo here</div></div>
    <div id="content">
        <!--左侧导航栏-->
        <div id="leftmenu">
            <div id="managermenu" ><div>用户与商品管理</div></div>
            <div id="selectmenu" class="menustyle">查看商品
                <%--<form action="ShopServlet" method="post">--%>
                    <%--<input type="submit" value="查看商品" >--%>
                <%--</form>--%>
            </div>
            <div id="addmenu" class="menustyle">添加商品</div>
            <div id="updatemenu" class="menustyle">修改商品</div>
            <div id="classesmenu" class="menustyle">类别管理</div>
            <div id="homepagemenu" class="menustyle">首页类别管理</div>
            <div id="orderinfo" class="menustyle">订单信息</div>
            <div id="aboutus" class="menustyle">关于</div>
        </div>
        <!--管理显示界面-->
        <div id="right">
            <div id="right0">welcome home</div>
            <!--查看商品信息界面-->
            <div id="right1">
                <table id="productlist1" border="1px">
                    <tr>
                        <%--<th>商品ID</th>--%>
                        <%--<th>商品名称</th>--%>
                        <%--<th>商品类型</th>--%>
                        <%--<th>商品品牌</th>--%>
                        <%--<th>生产日期</th>--%>
                        <%--<th>商品售价</th>--%>
                        <%--<th>商品库存</th>--%>
                        <%--<th>已售数量</th>--%>
                        <%--<th>商品图片</th>--%>
                        <%--<th>商品标题</th>--%>
                        <%--<th>商品介绍</th>--%>
                        <%--<th>修改日期</th>--%>
                        <%--<th>操作台</th>--%>
                            <th>商品ID</th>
                            <th>商品名称</th>
                            <th>商品图片</th>
                            <th>商品描述</th>
                            <th>商品价格</th>
                            <th>删除操作</th>
                    </tr>
                    <c:forEach items="${shops}" var="shop">
                        <tr>
                            <td>${shop.shop_id}</td>
                            <td>${shop.shop_name}</td>
                            <td><img src="http://localhost:8080/photo/${shop.shop_img}"></td>
                            <td>${shop.shop_des}</td>
                            <td>${shop.shop_price}</td>
                            <td>
                                <a href="delServet?id${shop.shop_id}">删除</a>></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <!--添加商品页面-->
            <div id="right2">
                <div id="addproduct_left">
                    <ul id="goodsname">
                        <li id="goos_name" >商品名称</li>
                        <li><input type="text" id="goods_name_input" placeholder="商品名称"></li>
                        <li>
                            <div>商品价格</div>
                            <div>商品库存</div>
                        </li>
                        <li>
                            <input type="text" placeholder="商品价格">
                            <input type="text" placeholder="商品库存">
                        </li>
                        <li>
                            <div>商品品牌</div>
                            <div>商品类型</div>
                        </li>
                        <li>
                            <input type="text" placeholder="商品品牌">
                            <input type="text" placeholder="商品类型">
                        </li>
                        <li id="goods_date">生产日期</li>
                        <li><input type="text" id="goods_date_input"placeholder="年/月/日"></li>
                    </ul>
                </div>
                <div id="addproduct_center">
                    <ul id="goodstype">
                        <li>商品标题</li>
                        <li><input type="text"placeholder="商品标题"></li>
                        <li>商品介绍</li>
                        <li><div class="product_introduce"><input type="text"class="product_introduce_input"></div></li>
                        <li><input type="submit" value="确认提交" id="addbutten"></li>
                    </ul>
                </div>
                <div id="addproduct_right">
                    <ul class="goodspicture">
                        <li><div></div></li>
                        <li><input type="button" value="选择图片" class="picture_button"></li>
                        <li><div class="product_picture"><input type="text"class="product_picture_input"></div></li>
                    </ul>
                </div>
            </div>
            <!--修改商品页面-->
            <div id="right3">
                <div id="deleteproduct_left">
                    <ul id="goodsID">
                        <li id="goods_ID" >商品ID</li>
                        <li>
                            <input type="text" id="goods_ID_input" placeholder="商品ID号">
                            <input type="button" id="goods_IDget_button" value="获取ID信息">
                        </li>
                        <li>
                            <div>商品名称</div>
                        </li>
                        <li><input type="text" placeholder="商品名称" id="goods_name_delete_select">
                        </li>
                        <li>
                            <div>商品价格</div>
                            <div>商品库存</div>
                        </li>
                        <li>
                            <input type="text" placeholder="商品价格">
                            <input type="text" placeholder="商品库存">
                        </li>
                        <li>
                            <div>商品品牌</div>
                            <div>商品类型</div>
                        </li>
                        <li>
                            <input type="text" placeholder="商品品牌">
                            <input type="text" placeholder="商品类型">
                        </li>
                    </ul>
                </div>
                <div id="deleteproduct_center">
                    <ul id="goodsmessage">
                        <li>生产日期</li>
                        <li><input type="text" placeholder="年/月/日"></li>
                        <li>商品标题</li>
                        <li><input type="text"placeholder="商品标题"></li>
                        <li>商品介绍</li>
                        <li><div class="product_introduce"><input type="text"class="product_introduce_input"></div></li>
                        <li><input type="submit" value="确认提交" class="deletebutten"></li>
                    </ul>
                </div>
                <div id="deleteproduct_right">
                    <ul class="goodspicture">
                        <li><div></div></li>
                        <li><input type="button" value="选择图片" class="picture_button"></li>
                        <li><div class="product_picture"><input type="text"class="product_picture_input"></div></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
