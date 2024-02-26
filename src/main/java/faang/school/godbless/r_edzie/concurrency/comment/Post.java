package faang.school.godbless.r_edzie.concurrency.comment;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String text;
    private String author;
    private List<Comment> comments;

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
    }
}
