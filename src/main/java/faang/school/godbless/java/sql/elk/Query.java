package faang.school.godbless.java.sql.elk;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Query {
    private final int id;
    private final String content;
    private LocalDateTime timestamp;

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public Query(int id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = LocalDateTime.parse(timestamp);;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("{id: %d, content: %s, datetime: %s}", this.id, this.content, timestamp.format(formatter));
    }
}
