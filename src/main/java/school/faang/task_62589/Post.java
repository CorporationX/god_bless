package school.faang.task_62589;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@AllArgsConstructor
@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments = new CopyOnWriteArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
