package com.neuedu;

        import com.neuedu.dao.UserDao;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
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
        System.out.println("密码"+username+"password"+password);

        UserDao userDao = new UserDao();
        boolean exists = userDao.isExists(username,password);
        if (exists == true)
        {
            req.getRequestDispatcher("shouye.jsp").forward(req,resp);
            return;
        }else
        {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }
}
