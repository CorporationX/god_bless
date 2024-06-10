package faang.school.godbless.BJS28888;

import java.time.Instant;

@lombok.Data
public class Data {
    private int id;
    private String value;
    private Instant timeStamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        timeStamp = Instant.now();
    }
}
