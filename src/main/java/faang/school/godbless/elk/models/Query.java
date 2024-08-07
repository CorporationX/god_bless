package faang.school.godbless.elk.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Query implements Comparable<Query> {

    private static int counter = 0;

    private int id;
    private String content;
    private LocalDateTime date;

    public Query(String content) {
        this.id = counter;
        this.content = content;
        this.date = LocalDateTime.now();
        counter++;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Query{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date.format(formatter) +
                '}';
    }

    // Due to used new Date for new query. Did reversed sort
    @Override
    public int compareTo(Query o) {
        return o.date.compareTo(this.date);
        //return this.date.compareTo(o.date);
    }
}
