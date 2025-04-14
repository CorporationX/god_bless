package school.faang.catchevents;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}