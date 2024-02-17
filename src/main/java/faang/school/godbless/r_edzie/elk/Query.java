package faang.school.godbless.r_edzie.elk;

import lombok.Data;

@Data
public class Query {
    private int id;
    private String content;
    private String timestamp;

    public Query(int id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
}
