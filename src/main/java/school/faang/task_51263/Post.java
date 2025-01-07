package school.faang.task_51263;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;

    private final List<Comment> comments;


    public Post(int id, @NonNull String title,
                @NonNull String content, @NonNull String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;

        this.comments = new CopyOnWriteArrayList<>();
    }

    public void addComment(@NonNull Comment comment) {
        comments.add(comment);
        log.info("Comment added to Post ID={} by Author='{}'", id, comment.author());
    }

    public void deleteComment(@NonNull LocalDateTime timestamp, @NonNull String author) {
        boolean removed = comments.removeIf(comment ->
                comment.timestamp().equals(timestamp) && comment.author().equals(author));
        if (removed) {
            log.info("Comment deleted from Post ID={} by Author='{}' at {}", id, author, timestamp);
        } else {
            log.warn("No comment found to delete from Post ID={} by Author='{}' at {}", id, author, timestamp);
        }
    }

    public List<Comment> getComments() {
        return List.copyOf(comments);
    }

}
