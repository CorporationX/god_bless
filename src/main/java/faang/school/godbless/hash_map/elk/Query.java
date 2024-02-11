package faang.school.godbless.hash_map.elk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;

@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Query implements Comparable<Query> {
    private int id;
    private String content;
    private long timestamp;

    @Override
    public int compareTo(Query o) {
        return Long.compare(this.getTimestamp(), o.getTimestamp());
    }
}