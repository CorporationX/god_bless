package school.faang.bjs279766;

import lombok.Data;

@Data
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        this.id = IdGenerator.generateId();
    }
}
