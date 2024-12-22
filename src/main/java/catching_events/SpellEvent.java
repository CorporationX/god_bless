package catching_events;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class SpellEvent {
    private int id;
    private static final List<String> EVENT_TYPES = List.of("Чары", "Трансфигурация", "Защита");
    private String eventTypes;
    private String action;

    public SpellEvent(int id, String eventTypes, String action) {
        validateEventTypes(eventTypes);
        this.id = id;
        this.eventTypes = eventTypes;
        this.action = action;
    }

    public void validateEventTypes(String eventTypes) {
        if (EVENT_TYPES.stream().noneMatch(s -> s.equalsIgnoreCase(eventTypes))) {
            throw new IllegalArgumentException("такого типа заклинания нет!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SpellEvent that = (SpellEvent) o;
        return id == that.id && Objects.equals(EVENT_TYPES, that.EVENT_TYPES) && Objects.equals(eventTypes, that.eventTypes) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, EVENT_TYPES, eventTypes, action);
    }

    @Override
    public String toString() {
        return "SpellEvent{" +
                "id=" + id +
                ", EVENT_TYPES=" + EVENT_TYPES +
                ", eventTypes='" + eventTypes + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
