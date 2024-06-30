package faang.school.godbless.multithreading_concurrency.task_1;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public final class Comment {
    private final int id;
    private final User author;
    private final String text;
    private final LocalDateTime dateTime;

    public Comment(int id, User author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.dateTime = LocalDateTime.now();
    }
}
