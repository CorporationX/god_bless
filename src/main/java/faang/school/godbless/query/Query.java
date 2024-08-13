package faang.school.godbless.query;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
public class Query {
    private int id;
    private String content;
    private Date timestamp;

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = new Date();
    }
}
