package faang.school.godbless.elk;

import java.time.LocalDateTime;

public class Query implements Comparable<Query> {
    private final int id;
    private final String content;
    private final LocalDateTime timeStamp = LocalDateTime.now();

    public Query(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public int compareTo(Query o) {
        return timeStamp.isAfter(o.getTimeStamp()) ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                '}' + "\n";
    }
}



