package school.faang.volatile_immutable_classes_deadlock_concurrency.bjs2_93619;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import static java.util.Collections.synchronizedList;

@RequiredArgsConstructor
public class Post {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private final List<Comment> comments = synchronizedList(new ArrayList<>());

    @Getter
    private final int id = COUNTER.incrementAndGet();
    @Getter
    private final String title;
    @Getter
    private final String content;
    @Getter
    private final User author;

    public boolean removeComment(Predicate<Comment> predicate) {
        return comments.removeIf(predicate);
    }

    public int countComment() {
        return comments.size();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}