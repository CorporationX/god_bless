package faang.school.godbless.IndexRequestELK;

import lombok.Getter;

import java.util.Calendar;

@Getter
public class Query {

    private static int LAST_ID = 0;

    private int id;
    private String content;
    private Calendar timestamp;

    public Query(Calendar timestamp, String content) {
        this.timestamp = timestamp;    // По хорошему, timestmap должен как и ид, создаваться сам (во время запроса собсна), но тогда я не смог бы сделать тестирование
        this.content = content;
        id = ++LAST_ID;
    }

    @Override
    public String toString() {
        return String.format("%s %did %s", content, id, timestamp.getTime());
    }
}
