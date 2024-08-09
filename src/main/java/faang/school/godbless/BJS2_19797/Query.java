package faang.school.godbless.BJS2_19797;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
public class Query {
    private int id;
    private String content;

    @Getter
    private Date date;

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.date = new Date();
    }
}
