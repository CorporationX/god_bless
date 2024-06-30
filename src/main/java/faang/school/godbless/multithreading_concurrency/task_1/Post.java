package faang.school.godbless.multithreading_concurrency.task_1;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public final class Post {
    private final int id;
    private final User author;
    private final String title;
    private final String text;
    private final List<Comment> comments = new ArrayList<>();
}
