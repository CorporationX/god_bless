package faang.school.godbless.elkindex;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@ToString
public class Query {
    private final int id;
    private final String content;
    private final LocalDateTime timestamp;
    private static int idFromDB;

    public Query(String content, LocalDateTime timestamp) {
        this.content = content;
        this.timestamp = timestamp;
        this.id = ++idFromDB;
    }
}
