package faang.school.godbless.BJS2_19796;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ToString
@Getter
public class Query implements Comparable<Query> {
    private static int nextId = 0;
    private int id;
    private String content;
    private final Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    public Query(String content) {
        id = nextId++;
        this.content = content;
        System.out.println("Created query with id " + this.id);
    }

    @Override
    public int compareTo(Query o) {
        return timestamp.compareTo(o.timestamp);
    }
}
