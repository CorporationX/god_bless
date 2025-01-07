package school.faang.sprint_4.task_43585;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record Post(int id, String title, String content, String author, List<Comment> comments) {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    public Post(String title, String content, String author, List<Comment> comments) {
        this(ID_GENERATOR.getAndIncrement(), title, content, author, comments);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}