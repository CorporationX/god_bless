package faang.school.godbless.sprint_1.index_requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Query {
    private static int startId = 0;

    private int id;
    private String content;
    private LocalDateTime timestamp;

    public Query(String content, LocalDateTime timestamp) {
        this.id = startId++;
        this.content = content;
        this.timestamp = timestamp;
    }
}
