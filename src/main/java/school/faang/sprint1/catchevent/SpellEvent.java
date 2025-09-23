package school.faang.sprint1.catchevent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Represents a magical spell event in Hogfwarts.
 */
@RequiredArgsConstructor
@ToString
@Getter
public class SpellEvent {

    private final int id;
    private final String eventType;
    private final String action;

}
