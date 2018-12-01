package com.neuedu;

import com.neuedu.businese.ShopBusinese;
import com.neuedu.businese.ShopBusineseImpl;
import com.neuedu.pojos.Shops;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        String des = req.getParameter("des");
        String price = req.getParameter("price");
        BigDecimal bigDecimal = new BigDecimal(price);
        ShopBusinese shopBusinese = new ShopBusineseImpl();
        Shops shops = new Shops(i,name,img,des,bigDecimal);
        shopBusinese.updateShop(shops);
        req.getRequestDispatcher("/ShopServlet").forward(req,resp);
    }
}