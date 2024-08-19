package faang.school.godbless.index.request.elk;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Getter
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        return "Query{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp.format(formatter) +
                '}';
    }
}
