package school.faang.task_44449;

import lombok.Getter;

@Getter
public class SpellEvent {
    private Integer id;
    private String eventType;
    private String action;

    public SpellEvent(Integer id, String eventType, String action) {
        if (id == null) {
            throw new IllegalArgumentException("Id не может быть пустым");
        }
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("eventType не может быть пустым");
        }
        if (action == null || action.isEmpty()) {
            throw new IllegalArgumentException("action не может быть пустым");
        }

        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
