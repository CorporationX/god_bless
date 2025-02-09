package school.faang.bjs2_56978;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
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
