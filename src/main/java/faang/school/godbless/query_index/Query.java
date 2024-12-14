package faang.school.godbless.query_index;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Query implements Comparable<Query> {
    private int id;
    private String content;
    private long timestamp;

    @Override
    public int compareTo(Query anotherQuery) {
        return Long.compare(this.timestamp, anotherQuery.timestamp);
    }
}
