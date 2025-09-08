package school.faang.BJS2_85892;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpellEvent {

    private static int idCounter = 1;
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = idCounter++;
        this.eventType = eventType;
        this.action = action;
    }
}
