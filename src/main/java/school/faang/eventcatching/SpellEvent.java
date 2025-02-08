package school.faang.eventcatching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;


}
