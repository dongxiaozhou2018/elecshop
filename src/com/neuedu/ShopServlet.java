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
import java.util.List;

@WebServlet(name = "ShopServlet",urlPatterns = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShopDao shopDao = new ShopDaoImpl();
        List<Shops> allShop = shopDao.getAllShop();
        req.setAttribute("shops",allShop);
        req.getRequestDispatcher("shouye.jsp").forward(req,resp);
    }
}
