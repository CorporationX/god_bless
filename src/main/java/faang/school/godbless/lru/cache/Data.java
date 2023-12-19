package faang.school.godbless.lru.cache;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
public class Data {
    private static int globalId = 0;
    private int id;
    @Setter
    private String value;
    @Setter
    private Timestamp timestamp;

    public Data (String value) {
        this.value = value;
        this.id = globalId++;
    }
}