package school.faang.bjs2_33253;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
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

    @Override
    public String toString() {
        return "{id: " + id + ", Тип события: " + eventType + ", Данные: " + data + "}";
    }
}
