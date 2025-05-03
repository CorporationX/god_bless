package leave.comments;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Post {
    private int id;
    private String title;
    private String content;
    private Author author;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String title, String content, Author author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
