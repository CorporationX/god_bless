package faang.school.godbless.javaHashMap.indexELK;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp; //Время создания запроса

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
