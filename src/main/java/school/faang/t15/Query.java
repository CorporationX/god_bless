package school.faang.t15;

import lombok.Data;

@Data
class Query {
    private int id;
    private String content;
    private long timestamp;

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }
}