package faang.school.godbless.LRUCache;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }
}
