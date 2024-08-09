package faang.school.godbless.lrucache;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class Data {
    @Getter
    private int id;
    private String value;
    private LocalDateTime timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }

    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }
}
