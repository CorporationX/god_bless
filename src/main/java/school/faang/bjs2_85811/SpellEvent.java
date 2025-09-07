package school.faang.bjs2_85811;

import lombok.Getter;

import java.util.Objects;

public class SpellEvent {
    private static int idCounter = 1;
    private final Integer id;
    @Getter
    private final String eventType;
    @Getter
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = idCounter++;
        this.eventType = eventType;
        this.action = action;
    }

    Integer uniqueId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, action);
    }

    @Override
    public String toString() {
        return "SpellEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
