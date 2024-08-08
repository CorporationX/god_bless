package index.elk;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@ToString
public class Query {
    private static int idCount = 1;
    private final int id;
    private final String content;
    private final LocalDateTime timestamp;

    public Query(@NonNull String content, @NonNull LocalDateTime timestamp) {
        this.id = idCount++;
        this.content = content;
        this.timestamp = timestamp;
    }
}
