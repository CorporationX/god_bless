package school.faang.bjs2_85845;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SpellEvent {
    private static int id = 0;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        id++;
    }

    public static int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public String getAction() {
        return action;
    }
}
