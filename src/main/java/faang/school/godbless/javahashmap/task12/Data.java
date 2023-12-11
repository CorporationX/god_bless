package faang.school.godbless.javahashmap.task12;

import java.time.LocalDateTime;


@lombok.Data
public class Data {
    private int id;
    private int value;
    private LocalDateTime timestamp;
    private static int count;

    public Data(int value) {
        this.id = ++count;
        this.value = value;
        this.timestamp = LocalDateTime.now();

    }
}
