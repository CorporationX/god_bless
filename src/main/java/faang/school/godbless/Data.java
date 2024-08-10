package faang.school.godbless;

import java.util.UUID;

@lombok.Data
public class Data {
    final private String id;
    final private String value;
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
