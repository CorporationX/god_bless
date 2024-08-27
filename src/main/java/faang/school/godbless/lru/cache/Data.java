package faang.school.godbless.lru.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Getter
public class Data {
    private int id;
    private String value;
    private LocalDateTime timestamp;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        updateTimestamp();
    }

    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        return "Data{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", timestamp=" + timestamp.format(formatter) +
                '}';
    }
}
