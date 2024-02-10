package faang.school.godbless.stream;

import java.util.Date;
import java.util.Objects;

public class StreamEvent {
    private Integer id;
    private String eventType;
    private String data;

    public StreamEvent(Integer id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamEvent that = (StreamEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(eventType, that.eventType) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, data);
    }

    public Integer getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public String getData() {
        return data;
    }
}
