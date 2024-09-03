package faang.school.godbless.sprint.four.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Post {
    private final long id;
    private final long userId;
    private final String title;
    private final String author;
    private List<Comment> comments = new CopyOnWriteArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(int commentId, long userId) {
        Comment comment = comments.stream()
                .filter(comment1 -> comment1.getId() == commentId && comment1.getUserId() == userId)
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException(String.format("Comment with ID %d not found for this userId %d%n", commentId, userId))
                );
        comments.remove(comment);
    }
}
