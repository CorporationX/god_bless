package faang.school.godbless.LRU_cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Data implements Comparable<Data> {
    private int id;
    private String value;
    private Instant timestamp;

    @Override
    public int compareTo(Data o) {
        return this.getTimestamp().compareTo(o.getTimestamp());
    }
}
