package school.faang.sprint1.collections.catchevents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

}
