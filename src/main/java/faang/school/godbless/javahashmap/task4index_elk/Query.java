package faang.school.godbless.javahashmap.task4index_elk;

import lombok.Data;

import java.time.LocalDateTime;

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
