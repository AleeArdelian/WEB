package jsp.controller;

import jsp.adaptor.dataBaseAdaptor;
import jsp.domain.Comment;
import jsp.domain.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class commentsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = null;
        int topic_id = (int) request.getSession().getAttribute("topic_id");
        int user_id = (int) request.getSession().getAttribute("user_id");
        String comment = request.getParameter("comment");


        dataBaseAdaptor db = new dataBaseAdaptor();
        db.connect();
        db.addComment(user_id,topic_id,comment);

        rd = request.getRequestDispatcher("/add.jsp");
        rd.forward(request, response);
        db.disconnect();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = null;
        int topicId = (int) request.getSession().getAttribute("topicId");
        int userId = (int) request.getSession().getAttribute("userId");

        dataBaseAdaptor db = new dataBaseAdaptor();
        db.connect();
        Set<Comment> com = db.getComments(topicId);

        rd = request.getRequestDispatcher("/displayComments.jsp");
        request.setAttribute("com", com);
        request.setAttribute("userId",userId);
        request.setAttribute("topicId",topicId);
        rd.forward(request, response);
        db.disconnect();
    }
}
