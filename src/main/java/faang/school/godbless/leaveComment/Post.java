package faang.school.godbless.leaveComment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {

    private final int id;
    private final String text;
    private final String author;
    private final String title;
    private final List<Comment> comments;

    public Post(int id, String text, String author, String title) {
        this.id = id;
        this.title = text;
        this.text = author;
        this.author = title;
        this.comments = new ArrayList<>();
    }

    public void addComments(Comment comment) {
        comments.add(comment);
    }

    public void deleteComment(String author) {
        comments.removeIf(comment -> comment.getAuthor().equals(author));
    }

}
