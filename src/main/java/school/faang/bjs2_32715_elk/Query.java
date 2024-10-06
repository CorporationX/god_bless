package school.faang.bjs2_32715_elk;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Query {
    private static int countId = 1;

    private final int id;
    private final String content;
    private LocalDateTime timestamp;

    public Query(String content) {
        this.id = countId++;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }


}
