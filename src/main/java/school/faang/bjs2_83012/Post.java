package school.faang.bjs2_83012;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@ToString
public class Post {
    private final long id;
    private final User author;
    private String title;
    private String content;

    private final List<Comment> comments;

    public Post(long id,
                @NonNull String title,
                @NonNull String content,
                @NonNull User author,
                @NonNull List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        log.info("Добавлен комментарий в пост с title={}", title);
    }
}
