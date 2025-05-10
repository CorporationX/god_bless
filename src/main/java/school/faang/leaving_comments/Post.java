package school.faang.leaving_comments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@AllArgsConstructor
@Getter
public class Post {
    private final int id = GlobalIdGenerator.generateId(Post.class);
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments = new CopyOnWriteArrayList<>();
}
