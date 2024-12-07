package school.faang.catch_events;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ToString
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String description;


}
