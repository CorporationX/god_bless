package faang.school.godbless.LRU_cache;

import java.time.LocalDateTime;

@lombok.Data
public class Data {
    private static int startId = 0;
    private int id;
    private String value;
    private LocalDateTime timestamp;

    public Data(String value) {
        this.id = startId++;
        this.timestamp = LocalDateTime.now();
        this.value = value;
    }
}
