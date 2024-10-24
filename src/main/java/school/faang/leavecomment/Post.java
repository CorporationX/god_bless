package school.faang.leavecomment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Synchronized;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();

    @Synchronized
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
