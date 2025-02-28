package school.faang.BJS2_62632;

import lombok.Getter;
import lombok.ToString;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ToString
@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final Set<Comment> comments = ConcurrentHashMap.newKeySet();

    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}