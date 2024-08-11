package faang.school.godbless.the_elk_query_index;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Query {
    private UUID id;
    private String content;
    private int timestamp;

    public Query(UUID id, String content, int timestamp) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (content == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (timestamp < 0) {
            throw new IllegalArgumentException("timestamp cannot be negative");
        }
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
}
