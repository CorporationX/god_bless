package faang.school.godbless.BJS2_25597;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    private String title;
    private String author;
    private String text;
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }
}
