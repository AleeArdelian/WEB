package jsp.domain;

public class Topic {
    private int id;
    private String title;
    private String content;

    public Topic(int i, String tit, String con){
        this.id=i;
        this.title=tit;
        this.content=con;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
}
