package jsp.controller;

import jsp.adaptor.dataBaseAdaptor;
import jsp.domain.Topic;
import jsp.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Set;


public class loginController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        RequestDispatcher requestDispatcher ;

        String username = req.getParameter("user");
        String password = req.getParameter("pass");

        dataBaseAdaptor db = new dataBaseAdaptor();
        db.connect();

        User user = db.getUser(username,password);
        Set<Topic> topics = db.getTopics();

         if(user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                req.setAttribute("topics", topics);
                requestDispatcher = req.getRequestDispatcher("/forumPage.jsp");

            }
            else{
             requestDispatcher = req.getRequestDispatcher("/index.jsp");
            }
            requestDispatcher.forward(req, res);
        db.disconnect();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
