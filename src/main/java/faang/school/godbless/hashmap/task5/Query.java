package faang.school.godbless.hashmap.task5;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
@Data
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp = LocalDateTime.now();
    private static int count;

    public Query(String content) {
        this.id = ++count;
        this.content = content;
    }
}
