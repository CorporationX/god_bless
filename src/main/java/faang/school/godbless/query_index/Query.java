package faang.school.godbless.query_index;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;


@AllArgsConstructor
@ToString
@Getter
public class Query implements Comparable<Query> {
    private int id;
    private String content;
    private Instant timestamp;

    @Override
    public int compareTo(Query o) {
        return - Instant.now().compareTo(o.getTimestamp());
    }
}
