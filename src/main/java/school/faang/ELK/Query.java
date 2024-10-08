package school.faang.ELK;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Query {
    private int id;
    private String content;
    private final LocalDateTime timestamp;

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
