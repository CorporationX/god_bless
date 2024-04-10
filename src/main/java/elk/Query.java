package elk;

import lombok.Getter;

import java.util.Date;

@Getter
public class Query {
    private int id;
    private String content;
    private Date timestamp;
    private static int counterId = 1;

    public Query(String content, Date timestamp) {
        this.id = counterId;
        this.content = content;
        this.timestamp = timestamp;
        counterId++;
    }
}
