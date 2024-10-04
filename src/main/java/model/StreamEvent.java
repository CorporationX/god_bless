package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreamEvent that)) return false;
        return getId() == that.getId() && Objects.equals(getEventType(), that.getEventType()) && Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEventType(), getData());
    }
}
