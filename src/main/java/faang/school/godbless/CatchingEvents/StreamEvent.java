package faang.school.godbless.CatchingEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamEvent that = (StreamEvent) o;
        return id == that.id && Objects.equals(eventType, that.eventType) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, data);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", '" + eventType +
                "', data " + data;
    }
}
