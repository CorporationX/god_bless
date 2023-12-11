package faang.school.godbless.BJS2_712;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Query {
    private static int count;
    private int id;
    private String content;
    private LocalDateTime timestamp;

    public Query(String content) {
        this.id = ++count;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Query id = " + id + ", content = " + content + ", timestamp = " + timestamp;
    }
}