package faang.school.godbless.multithreading_2.comment;

import java.util.ArrayList;
import java.util.List;

public record Post(int id, String head, String text, String author, List<Comment> comments) {

    public Post(int id, String head, String text, String author) {
        this(id, head, text, author, new ArrayList<>());
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
