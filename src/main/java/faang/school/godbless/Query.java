package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Query {
    protected static final Map<Query, Double> QUERY_LIST_MAP = new HashMap<>();
    private int id;
    private String content;
    private double timestamp;

    public Query(int id, String content, double timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public double getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return id == query.id && Double.compare(timestamp, query.timestamp) == 0 && Objects.equals(content, query.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, timestamp);
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
