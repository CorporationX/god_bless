package faang.school.godbless.queryIndex;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Getter
public class Query {
    private final long ID;
    private final String CONTENT;
    private final LocalDateTime TIMESTAMP;

    @Override
    public String toString() {
        return "Query{" +
                "id=" + ID +
                ", content='" + CONTENT + '\'' +
                ", timestamp=" + TIMESTAMP.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                '}';
    }
}
