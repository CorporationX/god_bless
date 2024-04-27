package faang.school.godbless.comment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    private static int idFromDB;
    private final int id;
    private final String author;
    private String headline;
    private String text;
    private List<Comment> comments;

    public Post(String author, String headline, String text) {
        this.id = ++idFromDB;
        this.author = author;
        this.headline = headline;
        this.text = text;
        this.comments = new ArrayList<>();
    }
}
