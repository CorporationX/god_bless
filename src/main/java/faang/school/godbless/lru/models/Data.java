package faang.school.godbless.lru.models;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Data {

    private final int id;
    private final String value;
    private LocalDateTime date;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
        updateDateToNow();
    }

    public void updateDateToNow() {
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Data{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", date=" + date.format(formatter) +
                '}';
    }
}
