package com.neuedu;

import com.neuedu.dao.ShopDao;
import com.neuedu.dao.ShopDaoImpl;
import com.neuedu.pojos.Shops;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "addProductServlet" ,urlPatterns = "/addProductServlet")
public class addProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shop_name = req.getParameter("shop_name");
        String shop_img = req.getParameter("shop_img");
        String shop_des = req.getParameter("shop_des");
        String string = req.getParameter("shop_price");
        BigDecimal shop_price = new BigDecimal(string);
        String shop_id = req.getParameter("id");
        Shops shops = new Shops(null,shop_name,shop_img,shop_des,shop_price);
        ShopDao shopsDao = new ShopDaoImpl();
        boolean b = shopsDao.addOneProduct(shops);
        System.out.println(b);
        if (b==true)
        {
            req.getRequestDispatcher("/ShopServlet").forward(req,resp);
            return;
        }
        req.getRequestDispatcher("/ShopServlet").forward(req,resp);
    }
}