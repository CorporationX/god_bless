package faang.school.godbless.r_edzie.elk;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Query implements Comparable<Query> {
    private int id;
    private String content;
    private final LocalDateTime timestamp = LocalDateTime.now();

    @Override
    public int compareTo(Query o) {
        if (timestamp.isAfter(o.getTimestamp())) {
            return 1;
        } else if (timestamp.isBefore(o.getTimestamp())) {
            return -1;
        }

        return 0;
    }
}
