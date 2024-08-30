package commenting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Slf4j
@AllArgsConstructor
public class Post {
    private static final AtomicInteger idCount = new AtomicInteger(0);
    private final int id = idCount.incrementAndGet();
    private String header;
    private String text;
    private final String author;
    private final Map<Integer, Comment> comments = new HashMap<>();

    public synchronized void addComment(@NonNull Comment comment) {
        if (comments.containsKey(comment.getId())) {
            log.error(Integer.toString(id));
            log.error(Integer.toString(comment.getId()));
            throw new IllegalArgumentException("This post already has comment with this id");
        }
        comments.put(comment.getId(), comment);
    }

    public synchronized void removeComment(int id, @NonNull String author) {
        if (comments.containsKey(id)) {
            if (comments.get(id).getAuthor().equals(author)) {
                comments.remove(id);
            } else {
                throw new IllegalArgumentException("Comment can be deleted only by its author!");
            }
        } else {
            throw new IllegalArgumentException("This post don't have comment with this id");
        }
    }

    public synchronized Comment getComment(int id) {
        return comments.get(id);
    }

    public synchronized List<Integer> getAllCommentsId() {
        return comments.keySet().stream().toList();
    }
}
