package faang.school.godbless.sprint4.comments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private int id;
    private String text;
    private String author;
    private String title;
    private List<Comment> comments;

    public Post(int id, String title, String text, String author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComments(Comment comments) {
        this.comments.add(comments);
    }

    public void deleteComment(String author) {
        for (Comment comment : comments) {
            if (comment.getAuthor().equals(author)) {
                comments.remove(comment);
            }
        }

    }
}
