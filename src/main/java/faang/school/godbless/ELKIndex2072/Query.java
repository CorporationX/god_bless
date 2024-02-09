package faang.school.godbless.ELKIndex2072;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Query implements Comparable<Query> {
    private int id;
    private String content;
    private long timestamp;
    private static int counter = 0;

    public Query(String content, long timestamp) {
        this.id = ++counter;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Query o) {
        return Long.compare(this.getTimestamp(), o.getTimestamp());
    }
}
