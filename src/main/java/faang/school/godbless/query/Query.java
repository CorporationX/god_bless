package faang.school.godbless.query;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Query {
    private int id;
    private String content;
    private Date timestamp = new Date();

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
    }
}
