package faang.school.godbless.lrucache;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Data {
    private final int id;
    private final int value;
    private LocalDateTime timestamp;

    public Data(int id, int value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }

    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }
}