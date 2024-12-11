package school.faang;

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
        return "id=" + id + ": '" + eventType + " — " + action + "'";
    }
}
