package faang.school.godbless.leavecomments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {

    private long id;
    private String header;
    private String text;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(long id, String header, String text, String author) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.author = author;
    }

    public void addCommentary(Comment comment) {
        comments.add(comment);
    }
}
