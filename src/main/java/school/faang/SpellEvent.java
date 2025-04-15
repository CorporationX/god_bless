package school.faang;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SpellEvent {
    private int id;
    @Getter @Setter
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }
}
