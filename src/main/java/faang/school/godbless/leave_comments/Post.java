package faang.school.godbless.leave_comments;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Post {
    private int id;
    private String author;
    private String title;
    private String text;
    private List<Comment> comments;

    public Post(int id, String author, String title, String text) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.comments = new ArrayList<>();
    }
}
