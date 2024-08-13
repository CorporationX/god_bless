package faang.school.godbless.BJS2_20336;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Data {
    private int id;
    private String value;
    private long timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }
}