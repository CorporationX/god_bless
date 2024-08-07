package faang.school.godbless.queryindex;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Query {
    private static int queryIdCounter = 100;

    private int id;
    private String content;
    private LocalDateTime timestamp;

    public Query(String content) {
        this.id = ++queryIdCounter;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
