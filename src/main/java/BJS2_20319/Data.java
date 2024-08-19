package BJS2_20319;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Data {
    private final int id;
    private final int value;
    private LocalDateTime timestamp;

    public Data(int id, int value, LocalDateTime timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
    }
}
