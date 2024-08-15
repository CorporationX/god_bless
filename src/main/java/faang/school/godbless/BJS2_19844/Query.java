package faang.school.godbless.BJS2_19844;

import lombok.Getter;

import lombok.ToString;
import java.util.Date;

@ToString
@Getter
public class Query {

    private int id;
    private String content;
    private final Date timestamp;

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = new Date();
    }
}
