package school.faang.sprint_4.task_51093;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
@Getter
@ToString
public class Post {
    private final int id;
    @NonNull
    private final String title;
    @NonNull
    private final String content;
    @NonNull
    private final String author;
    private final List<Comment> comments = new ArrayList<>();
    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    private final Lock lock = new ReentrantLock();

    public List<Comment> getComments() {
        return List.copyOf(comments);
    }

    public void addComment(Comment comment) {
        lock.lock();
        try {
            comments.add(comment);
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            comments.removeIf((comment -> comment.author().equals(author)
                    && comment.timestamp().equals(timestamp)));
        } finally {
            lock.unlock();
        }
    }
}
