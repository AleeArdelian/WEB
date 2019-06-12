<%@ page import="jsp.domain.User" %>
<%@ page import="jsp.domain.Topic" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 31-May-19
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum</title>
    <script src="script.js"></script>
</head>
<body>

<% User user;%>
<%
    user = (User) session.getAttribute("user");
    request.getSession().setAttribute("userId", user.getId());
    out.println("Welcome " + user.getUsername());

%>

<h1>Topics</h1>
<%
    Set<Topic> topics = (Set<Topic>) request.getAttribute("topics");
    for (Topic topic : topics) {
        request.getSession().setAttribute("topicId", topic.getId());

        out.print("<div style= \"width: 100%; height: 150px; background:#F9EECF; border:1px dotted black;text-align:center\">" );
        out.print("<h2>"+ topic.getTitle() + "</h2>");
        out.print("<p>" + topic.getContent() + "</p2>");
        out.print("<form action=\"Comments\" method=\"get\">");
        out.print("<input type=\"submit\" value=\"View comments\" >");
        out.print("</form>");
        out.print("</div>");
        out.print("<br>");
    }
%>
</body>
</html>
