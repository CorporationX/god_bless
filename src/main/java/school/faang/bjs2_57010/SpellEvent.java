package school.faang.bjs2_57010;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
    private static int count = 1;

    public SpellEvent(String eventType, String action) {
        this.id = count++;
        this.eventType = eventType;
        this.action = action;
    }
}
