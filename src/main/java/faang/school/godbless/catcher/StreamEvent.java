package faang.school.godbless.catcher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
public class StreamEvent {

    private final int id;
    private final String eventType;
    private final String data;

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
}
