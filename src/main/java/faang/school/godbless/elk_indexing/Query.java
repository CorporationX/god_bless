package faang.school.godbless.elk_indexing;

import java.time.Instant;
import java.util.Objects;

public class Query implements Comparable<Query> {
    private final int id;
    private final String content;
    private final Instant timeStamp;

    public Query(int id, String content, Instant timeStamp) {
        this.id = id;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return timeStamp.toString() + " " + id + " " + content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, timeStamp);
    }

    @Override
    public boolean equals(Object o) {
        Objects.requireNonNull(o);
        if (! (this == o) && this.getClass() != o.getClass()) return false;
        Query other = (Query) o;
        return id == other.id && Objects.equals(content, other.content) && Objects.equals(timeStamp, other.timeStamp);
    }

    @Override
    public int compareTo(Query o) {
        if(o == null) return -1;
        return timeStamp.compareTo(o.timeStamp);
    }
}
