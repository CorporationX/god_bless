package faang.school.godbless.BJS2_20020;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Query {
    private int id;
    private String content;
    private Timestamp timestamp;

    public Query(int id, String content, Timestamp timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
}
