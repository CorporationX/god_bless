package faang.school.godbless.lru.cache;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Data {
    private int id;
    private String value;
    private Timestamp timestamp;

    public Data (int id, String value) {
        this.id = id;
        this.value = value;
    }
}