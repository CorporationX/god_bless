package faang.school.godbless.LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Post {
    private String id;
    private String title;
    private String description;
    private String author;
    private final List<Comment> comments = new ArrayList<>();

    public Post(String title, String description, String author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(String commentId) {
        comments.removeIf(comment -> comment.getId().equals(commentId));
    }
}
