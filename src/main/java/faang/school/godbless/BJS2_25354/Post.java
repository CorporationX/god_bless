package faang.school.godbless.BJS2_25354;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
public class Post {
    private final String title;
    private final String text;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}