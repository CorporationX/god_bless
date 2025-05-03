package faang.BJS2_75968;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;

    private final List<Comment> comments = new ArrayList<>();

    public synchronized void add(Comment comment) {
        comments.add(comment);
    }

    public synchronized void deleteComment(Comment comment) {
        comments.remove(comment);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }
}


