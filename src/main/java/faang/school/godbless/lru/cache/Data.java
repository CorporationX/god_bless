package faang.school.godbless.lru.cache;

import lombok.Getter;

import java.sql.Timestamp;

public class Data {
    private static int globalId = 0;
    private Timestamp timestamp;
    @Getter
    private final int id;
    @Getter
    private final String value;

    public Data(String value) {
        this.value = value;
        this.id = globalId++;
    }

    public void updateTimestamp() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}