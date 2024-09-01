package faang.school.godbless.BJS2_25304;

import java.util.ArrayList;
import java.util.List;

public record Post(int id, String header, String text, String author, List<Comment> comments) {

    public Post(int id, String header, String text, String author) {
        this(id, header, text, author, new ArrayList<>());
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
