package faang.school.godbless;

import lombok.Getter;

import java.util.UUID;

public class Data {
    @Getter
    private String id;
    @Getter
    private String value;
    @Getter
    private long timestamp;

    public Data(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        this.id = UUID.randomUUID().toString();
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }

    public void updateTimestamp() {
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "id: " + id + ", value: " + value + ", timestamp: " + timestamp;
    }
}
