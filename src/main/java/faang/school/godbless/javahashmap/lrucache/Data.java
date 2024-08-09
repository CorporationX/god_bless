package faang.school.godbless.javahashmap.lrucache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Data {
    private int id;
    private String value;
    private long timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public void updateTimestamp() {
        timestamp = System.currentTimeMillis();
    }
}
