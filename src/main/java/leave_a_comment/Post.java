package leave_a_comment;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@ToString
public class Post {
    private static final Random RANDOM = new Random();
    private String title;
    private String text;
    private User author;
    private int id;
    private List<Comment> comments;

    public Post(String title, String text, User author) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.id = RANDOM.nextInt(1000) + 1000;
        this.comments = new ArrayList<>();
    }
}
