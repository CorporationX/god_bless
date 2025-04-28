package school.faang.facebook;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Post {
    @Getter
    private final int id;
    @Getter
    private final String title;
    @Getter
    private final String content;
    @Getter
    private final String author;
    private final List<Comment> comments = new CopyOnWriteArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public boolean removeComment(Comment comment, String requester) {
        if (comment.getAuthor().equals(requester)) {
            return comments.remove(comment);
        }
        return false;
    }
}
