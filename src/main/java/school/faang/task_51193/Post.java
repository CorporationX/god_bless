package school.faang.task_51193;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@RequiredArgsConstructor
public class Post {
    private final UUID id = UUID.randomUUID();
    private final String title;
    private final String content;
    private final User author;
    private final Map<UUID, Comment> comments = new ConcurrentHashMap<>();

    public Comment getComment(@NonNull UUID commentId) {
        return comments.get(commentId);
    }

    public void addComment(@NonNull Comment comment) {
        comments.put(comment.getId(), comment);
    }

    public void deleteComment(@NonNull UUID commentId) {
        comments.remove(commentId);
    }
}
