<%@ page import="jsp.domain.Topic" %>
<%@ page import="java.util.Set" %>
<%@ page import="jsp.domain.Comment" %><%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 06-Jun-19
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
    <h1>Comments</h1>
        <%
            Set<Comment> comments = (Set<Comment>) request.getAttribute("com");
            int user_id = (int) request.getSession().getAttribute("userId");
            int topic_id = (int) request.getSession().getAttribute("topicId");
            request.getSession().setAttribute("topic_id", topic_id);
            request.getSession().setAttribute("user_id", user_id);

            out.print("<form action=\"Comments\" method=\"post\">");
            out.print("Add a comment: <input type=\"text\" name=\"comment\"><br>");
            out.print("<input type=\"submit\" value=\"Add comment\" >");
            out.print("</form>");

            for (Comment com : comments) {
                out.print("<div style= \"width: 100%; height: 50px; background:#CEF6F5; border:1px dotted black;text-align:center\">" );
                out.print("<p>" + com.getComment() + "</p>");
                out.print("</div>");
                out.print("<br>");
            }

        %>
</body>
</html>
