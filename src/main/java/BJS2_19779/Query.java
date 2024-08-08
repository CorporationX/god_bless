package BJS2_19779;

import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

@ToString
public class Query {
    private int id;
    private String content;
    private LocalDateTime timeStamp;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Query(int id, String content, LocalDateTime timeStamp) {
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return getId() == query.getId() && Objects.equals(getContent(), query.getContent()) && Objects.equals(getTimeStamp(), query.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getTimeStamp());
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
}
