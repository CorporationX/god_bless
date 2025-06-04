package school.faang.cathing_events_bjs2_79681;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
