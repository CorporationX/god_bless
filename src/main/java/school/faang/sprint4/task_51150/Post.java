package school.faang.sprint4.task_51150;

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
    private final List<Comment> comments = new ArrayList<>();
}
