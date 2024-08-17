package faang.school.godbless.task.lru.cache;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
    @Getter
    private final Long id;
    private String value;
    @Setter
    private LocalDateTime timeStamp;

    public Data(Long id, String value) {
        this.id = id;
        this.value = value;
        this.timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", value=" + value +
                ", time=" + timeStamp.format(DateTimeFormatter.ISO_TIME);
    }
}
