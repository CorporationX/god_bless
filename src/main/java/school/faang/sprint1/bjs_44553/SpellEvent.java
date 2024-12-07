package school.faang.sprint1.bjs_44553;

import lombok.Getter;

public class SpellEvent {
    private final int id;
    @Getter
    private final String eventType;
    @Getter
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public String toString() {
        return "Events{" +
                "Id=" + id + ", eventType=" + eventType + ", action=" + action + " }";
    }
}
