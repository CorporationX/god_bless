package faang.school.godbless.lrucache;

import lombok.Getter;

import java.time.Instant;

@Getter
public class Data {
    private int id;
    private int value;
    private Instant timestamp;

    public Data(int id, int value) {
        this.id = id;
        this.value = value;
        this.timestamp = Instant.now();
    }

    public void updateTimestamp() {
        this.timestamp = Instant.now();
    }
}