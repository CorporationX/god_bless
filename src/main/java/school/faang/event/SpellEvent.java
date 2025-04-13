package school.faang.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
