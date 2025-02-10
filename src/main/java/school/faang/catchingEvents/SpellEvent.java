package school.faang.catchingEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
