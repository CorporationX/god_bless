package school.faang.bjs2_85902;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SpellEvent {

    private static int idStatic = 1;
    private int id = idStatic;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = idStatic++;
        this.eventType = eventType;
        this.action = action;
    }
}
