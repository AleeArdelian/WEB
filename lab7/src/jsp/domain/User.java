package jsp.domain;

public class User {

    private int Id;
    private String username;
    private String password;

    public User(int i,String user, String pass){
        this.Id = i;
        this.username=user;
        this.password=pass;
    }

    public int getId(){
        return Id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
