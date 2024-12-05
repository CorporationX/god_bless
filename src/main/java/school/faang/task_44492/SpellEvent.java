package school.faang.task_44492;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    @Override
    public String toString() {
        return "id: " + id + " | " + "eventType:" + eventType + " | " + "action:" + action;
    }
}
