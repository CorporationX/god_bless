package school.faang.events.catching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

}
