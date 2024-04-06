package faang.school.godbless.lrucache;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Data {
    private int id;
    private int value;
    private LocalDateTime timestamp;

    public Data(int id, int value) {
        this.id = id;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }
}
