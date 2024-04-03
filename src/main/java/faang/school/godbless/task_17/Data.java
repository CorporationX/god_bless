package faang.school.godbless.task_17;

import java.time.LocalDateTime;

@lombok.Data
public class Data {
    private final int id;
    private int value;
    private LocalDateTime timestamp;

    public Data(int id, int value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }
}
