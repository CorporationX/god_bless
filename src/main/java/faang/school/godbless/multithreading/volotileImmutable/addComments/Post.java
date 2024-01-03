package faang.school.godbless.multithreading.volotileImmutable.addComments;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Post {
    private final String title;
    private final String textPost;
    private final String author;
    private final List<Comment> comments;

    public Post(String title, String textPost, String author) {
        this.title = title;
        this.textPost = textPost;
        this.author = author;
        this.comments = new ArrayList<>();
    }
}
