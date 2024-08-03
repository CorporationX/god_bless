package BJS2_20085;

import java.time.Instant;

@lombok.Data
public class Data {
    private int id;
    private String value;
    private Instant timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = Instant.now();
    }

    public void updateTimestamp() {
        this.timestamp = Instant.now();
    }
}
