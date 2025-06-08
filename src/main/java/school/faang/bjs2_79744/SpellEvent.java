package school.faang.bjs2_79744;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
    }
}
