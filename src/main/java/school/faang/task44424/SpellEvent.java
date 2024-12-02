package school.faang.task44424;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    @Override
    public String toString() {
        return "SpellEvent: " +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", action='" + action + '\'';
    }
}
