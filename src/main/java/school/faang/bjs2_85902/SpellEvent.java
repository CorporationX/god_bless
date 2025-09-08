package school.faang.bjs2_85902;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class SpellEvent {

    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action, int id) {
        this.eventType = eventType;
        this.action = action;
        this.id = id;
    }
}
