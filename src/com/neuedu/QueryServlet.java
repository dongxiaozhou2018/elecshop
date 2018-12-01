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
import java.util.List;


    @WebServlet(name = "QueryServlet",urlPatterns = "/QueryServlet")
    public class QueryServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            int i = Integer.parseInt(id);
            ShopBusinese shopBusinese = new ShopBusineseImpl();
            Shops oneShop = shopBusinese.getOneShop(i);
            req.setAttribute("shop",oneShop);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        }
    }


