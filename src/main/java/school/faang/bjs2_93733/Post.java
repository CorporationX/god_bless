package school.faang.bjs2_93733;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}
