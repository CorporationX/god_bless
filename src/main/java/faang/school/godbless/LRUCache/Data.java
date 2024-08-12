package faang.school.godbless.LRUCache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@ToString
public class Data {
    private final int id;
    private final int value;

    private LocalDateTime timestamp;
    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    public Data(int id, int value) {
        this.id = id;
        this.value = value;
    }
}
