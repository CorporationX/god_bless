package school.faang.stream4.facebookleavingacomment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private List<Comment> comments = new ArrayList<>();

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }
}
