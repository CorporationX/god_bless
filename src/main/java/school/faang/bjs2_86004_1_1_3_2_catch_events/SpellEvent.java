package school.faang.bjs2_86004_1_1_3_2_catch_events;

import lombok.Getter;

import java.util.Objects;

public class SpellEvent {
    public static Integer ids = 0;

    @Getter
    private final Integer id;
    @Getter
    private final String eventType;
    @Getter
    private final String action;

    public SpellEvent(Integer id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Id: " + this.getId() + "\tТип: " + this.getEventType() + "\tДействие: " + this.getAction();
    }
}
