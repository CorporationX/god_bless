package faang.school.godbless.sprint2.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Evgenii Malkov
 */
@Getter
@Slf4j
public class Post {
    private final AtomicLong commentCounter = new AtomicLong(0);
    @Setter
    private Long id;
    private final String header;
    private final String text;
    private final User author;
    private volatile List<Comment> comments = new ArrayList<>();

    public Post(String header, String text, User author) {
        this.header = header;
        this.text = text;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comment.setId(commentCounter.getAndIncrement());
        comments.add(comment);
        if (this.id == 18) {
            log.error("TEST ID: {}. Список такой: {}", comment.getId(), getComments());
        }
        log.info("Комментарий {} успешно добавлен в пост {}", comment.getId(), this.getId());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("author=" + author)
                .add("comments=" + comments)
                .toString();
    }
}
