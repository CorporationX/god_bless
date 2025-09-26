package school.faang.bjs2_93610;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;

    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public boolean removeComment(Comment comment, String requester) {
        if (comment.getAuthor().equals(requester)) {
            return comments.remove(comment);
        }
        return false;
    }
}
