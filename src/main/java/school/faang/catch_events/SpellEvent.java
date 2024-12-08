package school.faang.catch_events;

import lombok.ToString;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ToString
@RequiredArgsConstructor
public class SpellEvent {
    private final int id;
    @Getter
    private final Enum eventType;
    private final String description;
}

