package faang.school.godbless.events;

import lombok.*;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString

public class StreamEvent {
    private final int ID;
    private String eventType;
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamEvent that = (StreamEvent) o;
        return ID == that.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }
}



