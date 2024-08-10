package faang.school.godbless.BJS2_19797;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class Query implements Comparable<Query> {
    private int id;
    private String content;
    private Date date;

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
        this.date = new Date();
    }

    @Override
    public int compareTo(Query o) {
        return date.compareTo(o.date);
    }
}
