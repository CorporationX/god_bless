package BJS2_19779;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@EqualsAndHashCode
public class Query {
    private final int id;
    private final String content;
    private final LocalDateTime timeStamp;

    public Query(int id, String content, LocalDateTime timeStamp) {
        this.id = id;
        this.content = content;
        this.timeStamp = timeStamp;
    }
}
