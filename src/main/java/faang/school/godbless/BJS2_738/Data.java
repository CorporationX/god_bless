package faang.school.godbless.BJS2_738;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@lombok.Data
public class Data {
    private static int count = 0;
    private final int id;
    private final String value;
    private LocalDateTime timestamp;

    public Data(String value) {
        this.id = ++count;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }

    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}