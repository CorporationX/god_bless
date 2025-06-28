package school.faang.commentator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RequiredArgsConstructor
@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private List<Comment> comments = new CopyOnWriteArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
