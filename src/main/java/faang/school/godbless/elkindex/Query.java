package faang.school.godbless.elkindex;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Query implements Comparable<Query> {

    private long id;
    private String content;
    private long timestamp;

    @Override
    public int compareTo(Query query) {
        return Long.compare(this.timestamp, query.timestamp);
    }
}