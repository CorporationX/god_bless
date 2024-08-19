package faang.school.godbless;

import lombok.Getter;

import java.util.*;

@Getter
public class Query {
    private int id;
    private String content;
    private Date timestamp;

    public Query(int id, String content, Date timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Query{" + "id=" + id + ", content='" + content + '\'' + ", timestamp=" + timestamp + '}';
    }


}
