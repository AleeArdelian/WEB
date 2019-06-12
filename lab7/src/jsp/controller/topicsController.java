package jsp.controller;

import jsp.adaptor.dataBaseAdaptor;
import jsp.domain.Topic;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;

public class topicsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = null;

        dataBaseAdaptor db = new dataBaseAdaptor();
        db.connect();
        Set<Topic> topics = db.getTopics();

        rd = request.getRequestDispatcher("displayComments.jsp");
        request.setAttribute("topics", topics);
        rd.forward(request, response);
        db.disconnect();
    }
}
