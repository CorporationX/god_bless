package faang.school.godbless.BJS2_20317;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ToString
@Getter
public class Data {
    private static int nextId = 0;

    private int id;
    private String value;
    private Timestamp timestamp;

    public Data(String value) {
        id = nextId++;
        this.value = value;
    }

    protected void updateTimestamp() {
        timestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
