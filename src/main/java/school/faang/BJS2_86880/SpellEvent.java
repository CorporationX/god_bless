package school.faang.BJS2_86880;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SpellEvent {
    private static int nextId = 0;
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        id = ++nextId;
        this.eventType = eventType;
        this.action = action;
    }
}
