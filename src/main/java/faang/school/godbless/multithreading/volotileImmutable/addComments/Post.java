package faang.school.godbless.multithreading.volotileImmutable.addComments;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Post {
    @Getter
    private final String title;
    @Getter
    private final String textPost;
    @Getter
    private final String author;

    private final List<Comment> comments;

    public Post(String title, String textPost, String author) {
        this.title = title;
        this.textPost = textPost;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

}
