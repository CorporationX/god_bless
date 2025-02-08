package school.faang.task_57109;

import lombok.Getter;

@Getter
public class SpellEvent {
    private static int idCounter = 0;
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = ++idCounter;
        this.eventType = eventType;
        this.action = action;

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
