package faang.school.godbless.BJS2_4137;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Data {
    int id;
    String value;
    long timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        updateTimestamp();
    }

    void updateTimestamp() {
        this.timestamp = System.currentTimeMillis();
    }
}
