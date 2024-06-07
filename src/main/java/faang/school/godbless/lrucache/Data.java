package faang.school.godbless.lrucache;

import java.time.Instant;

@lombok.Data
public class Data implements WithId {

    private Integer id;
    private String value;
    private Instant timestamp;

    public Data(String value, Instant timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
