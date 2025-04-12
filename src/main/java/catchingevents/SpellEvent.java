package catchingevents;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
