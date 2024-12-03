package school.faang.task_43513;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpellEvent {
    private int id;
    private EventType eventType;
    private String action;

    @Override
    public String toString() {
        return "SpellEvent [id=" + id + ", eventType=" + eventType + ", action=" + action + "]";
    }
}
