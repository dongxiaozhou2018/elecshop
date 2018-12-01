package com.neuedu;

        import com.neuedu.businese.UserBusinese;
        import com.neuedu.businese.UserBusineseImpl;
        import com.neuedu.dao.UserDao;
        import com.neuedu.dao.UsersDao;
        import com.neuedu.dao.UsersDaoImpl;
        import com.neuedu.pojos.User;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

//@WebServlet(name = "helloServ",urlPatterns = "/helloServlet")
public class helloServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        response.getWriter().write("hello Servl");
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean exists = false;
        if (username !=null && !"".equals(username)&& password != null && !"".equals(password))
        {
            UserBusinese userBusinese = new UserBusineseImpl();
            User compareuser = new User();
            compareuser.setUserName(username);
            compareuser.setPassWord(password);
            exists = userBusinese.userIsExist(compareuser);
        }
        if (exists == true)
        {
            Cookie cookie = new Cookie("logincookie",username);
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            req.getRequestDispatcher("/ShopServlet").forward(req,resp);
            return;
        }else
        {
            Cookie[] cookies = req.getCookies();
            if (cookies != null){
                for (Cookie c:cookies) {
                    if ("logincookie".equals(c.getName()))
                    {
                        req.getRequestDispatcher("/ShopServlet").forward(req,resp);
                        return;
                    }else{
                        req.getRequestDispatcher("index.jsp").forward(req,resp);
                        return;
                    }
                }
            }
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}