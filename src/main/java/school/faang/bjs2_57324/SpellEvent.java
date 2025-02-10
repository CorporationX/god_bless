package school.faang.bjs2_57324;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpellEvent {
    private static int id = 0;
    private String eventType;
    private String action;

    public static int getId() {
        return id;
    }

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        id++;
    }
}
