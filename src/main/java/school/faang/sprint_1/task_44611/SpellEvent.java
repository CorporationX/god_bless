package school.faang.sprint_1.task_44611;

import lombok.Getter;
import lombok.ToString;

@ToString
public class SpellEvent {
    private int id;
    @Getter
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
