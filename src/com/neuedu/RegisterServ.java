package com.neuedu;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UsersDao;
import com.neuedu.dao.UsersDaoImpl;
import com.neuedu.pojos.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Servlet的生命周期

@WebServlet(name = "RegisterServ" ,value={"/registerServ","/registerServ2"})
public class RegisterServ extends HttpServlet {

    public RegisterServ(){
        System.out.println("构造方法");

    }
    @Override
    public void init() throws ServletException {
        System.out.println("初始化方法");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service方法");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");
        String zipcode = req.getParameter("zipcode");
        String id = req.getParameter("id");
        User user = new User(null,username,password,email,tel);
        UsersDao usersDao = new UsersDaoImpl();
        boolean b = usersDao.addOneUser(user);
        System.out.println(b);
        if (b==true)
        {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }else{
            req.setAttribute("message","注册失败");
            req.getRequestDispatcher("userRegister.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
