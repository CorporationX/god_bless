package faang.school.godbless.javaHashMap.LRU_Cache;

import java.time.LocalDateTime;

@lombok.Data
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp; // Last time accessed

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }

    public void updateTimestamp() {
        setTimestamp(LocalDateTime.now());
    }
}
