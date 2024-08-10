package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
public class Query {
    private UUID id;
    private String content;
    private LocalDateTime timestamp;

    Query(String content) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", content=" + content + ", timestamp" + timestamp + " }";
    }
}
