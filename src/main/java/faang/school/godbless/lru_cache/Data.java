package faang.school.godbless.lru_cache;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class Data {
    private final int id;
    private String value;
    private long timestamp;

    public Data(int id, String value) {
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative");
        }
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().getEpochSecond();
    }

    public void setTimestamp(long timestamp) {
        if (timestamp < 0) {
            throw new IllegalArgumentException("Timestamp cannot be negative");
        }
        this.timestamp = timestamp;
    }

    public void setValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }
        this.value = value;
    }
}
