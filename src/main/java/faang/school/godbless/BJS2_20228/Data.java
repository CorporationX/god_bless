package faang.school.godbless.BJS2_20228;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
public class Data implements Comparable<Data> {
    private static int indexData = 0;
    @Getter
    private int id;
    @Getter
    private String value;
    @Getter
    @EqualsAndHashCode.Exclude
    private LocalDateTime timestamp;

    public Data(String value) {
        this.value = value;
        this.id = ++indexData;
        this.timestamp = LocalDateTime.now();
    }

    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public int compareTo(Data data) {
        return this.timestamp.compareTo(data.getTimestamp());
    }
}
