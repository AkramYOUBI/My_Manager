package web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginBean;
import dao.LoginDao;
import metier.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        
        try {
        	User util=loginDao.validate(loginBean);
            if (util.isStatus()) {
                HttpSession session = request.getSession();
                session.setAttribute("username",util.getUsername());
                session.setAttribute("fct",util.getFct());
                System.out.println(util.getFct());
                session.setAttribute("connected",util.isStatus());
                response.sendRedirect("equipements.jsp");
            } else {
                //HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                response.sendRedirect("loginEr.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
    }
}