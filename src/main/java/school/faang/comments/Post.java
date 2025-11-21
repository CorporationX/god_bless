package school.faang.comments;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class Post {
    private final long id;
    private final String title;
    private final String text;
    private final User author;
    private final List<Comment> comments;
}
