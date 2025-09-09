package school.faang.BJS2_86880;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class SpellEvent {
    private static int next_id = 0;
    private int id;
    private String eventType;
    private String action;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return Objects.equals(eventType, that.eventType) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, action);
    }

    public SpellEvent(String eventType, String action) {
        id = ++next_id;
        this.eventType = eventType;
        this.action = action;
    }
}
