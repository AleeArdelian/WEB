package jsp.domain;

public class Comment {
    private int Id;
    private int user_id;
    private int topic_id;
    private String comment;

    public Comment(int i, int u, int t, String com) {
        this.Id = i;
        this.user_id = u;
        this.topic_id = t;
        this.comment = com;
    }

    public int getId() {
        return Id;
    }

    public int getUserId() {
        return user_id;
    }

    public int getTopicId() {
        return topic_id;
    }

    public String getComment() {
        return comment;
    }
}

