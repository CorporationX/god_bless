package school.faang.BJS2_62597;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RequiredArgsConstructor
@Getter
@ToString
public class Post {

    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments = new CopyOnWriteArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public boolean removeComment(Comment comment, String author) {
        if (comment.getAuthor().equals(author)) {
            return comments.remove(comment);
        }
        return false;
    }
}
