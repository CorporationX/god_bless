package school.faang.bjs2_79687_spell_events;

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
