package lru.cache;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Data {

    private int id;
    private String data;
    private LocalDateTime timestamp;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Data(int id, String data) {
        this.id = id;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "data = '" + data + '\'' +
                ", timestamp = " + timestamp.format(DATE_TIME_FORMATTER);
    }
}

