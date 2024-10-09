package dima.evseenko.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id", "content"})
@AllArgsConstructor
public class Query implements Comparable<Query> {
    private final Long timestamp = System.currentTimeMillis();

    private Long id;
    private String content;

    @Override
    public int compareTo(Query o) {
        return o.timestamp.compareTo(this.timestamp);
    }
}
