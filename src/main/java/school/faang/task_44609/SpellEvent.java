package school.faang.task_44609;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SpellEvent {

    private final int id;

    private final String eventType;

    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpellEvent{")
                .append("id=").append(id)
                .append(", eventType='").append(eventType).append('\'')
                .append(", action='").append(action).append('\'')
                .append('}');
        return stringBuilder.toString();
    }
}
