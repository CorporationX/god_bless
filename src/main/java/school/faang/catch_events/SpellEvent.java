package school.faang.catch_events;

import java.util.Objects;
import lombok.ToString;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ToString
@Getter
@RequiredArgsConstructor
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return id == that.id && Objects.equals(eventType, that.eventType) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, eventType, action);
        return 31 * result + Objects.hash(id, eventType, action);
    }
}
