package school.faang.task_62589;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final Map<LocalDateTime, Comment> comments = new ConcurrentHashMap<>();

    public void addComment(Comment comment) {
        comments.put(comment.getTimestamp(), comment);
    }
}
