package comments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private int id;
    private String title;
    private String content;
    private User author;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String title, String content, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment, User user) {
        if (comment.getAuthor().equals(user)) {
            comments.remove(comment);
        }
    }
}
