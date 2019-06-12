package jsp.adaptor;

import jsp.domain.Comment;
import jsp.domain.Topic;
import jsp.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class dataBaseAdaptor {
    private String driver;
    private String connectionString;
    private String username;
    private String password;
    private Connection connection;

    public dataBaseAdaptor() {
        this.driver = "com.mysql.jdbc.Driver";
        this.connectionString = "jdbc:mysql://localhost:3306/forum";
        this.username = "root";
        this.password = "";
    }

    public void connect() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionString, username, password);
        } catch(Exception ex) {
            System.out.println("Error while connecting: "+ex.getMessage());
        }
    }

    public void disconnect(){
        try{
            connection.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public User getUser(String name, String pass) {
        User user = null;
        try {
            ResultSet resultSet;
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users where username = '" + name + " 'and pass = '" + pass + "'");

            if (resultSet.next()) {
                user = new User(resultSet.getInt("Id"), resultSet.getString("username"), resultSet.getString("pass"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Set<Topic> getTopics(){
        Set<Topic> topics = new HashSet<>();
        try {
            ResultSet resultSet;
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from topics");

            while(resultSet.next()) {
                Topic top = new Topic(resultSet.getInt("Id"), resultSet.getString("title"), resultSet.getString("content"));
                topics.add(top);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }

    public Set<Comment> getComments(int topicId) {
        Set<Comment> comments = new HashSet<>();
        try {
            ResultSet resultSet;
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from comments where topic_id=" + topicId);
            while (resultSet.next()) {
                Comment c = new Comment(resultSet.getInt("Id"), resultSet.getInt("user_id"), resultSet.getInt("topic_id"), resultSet.getString("comment"));
                comments.add(c);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public void addComment(int userId, int topicId, String comment){
        try {

            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into comments(user_id, topic_id,comment) values(?, ?,?)");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, topicId);
            preparedStatement.setString(3,comment);
            preparedStatement.executeUpdate();
            //resultSet = statement.executeQuery("insert into comments where topic_id=" + topicId);
            preparedStatement.clearParameters();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
