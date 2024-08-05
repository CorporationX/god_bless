package faang.school.godbless.BJS2_20020;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Data
public class Query {
    private int id;
    private String content;
    private Timestamp timestamp;

    public Query(int id, String content, Timestamp timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Query query)) return false;
        return getId() == query.getId() && Objects.equals(getContent(), query.getContent()) && Objects.equals(getTimestamp(), query.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getTimestamp());
    }
}
