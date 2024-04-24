package faang.school.godbless.leave_a_comment;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Post {
    private static int startId = 0;
    private int id;
    private String header;
    private String content;
    private User author;
    private Map<Integer, Comment> comments;

    public Post(String header, String content, User author) {
        this.id = startId++;
        this.header = header;
        this.content = content;
        this.author = author;
        this.comments = new HashMap<>();
    }

    public void addComment(Comment comment) {
        comments.put(comment.getId(), comment);
    }
    public void deleteComment(Comment comment) {
        comments.remove(comment.getId());
    }
}