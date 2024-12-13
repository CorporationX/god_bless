package school.faang.s13task44546;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class SpellEvent {
    private final int id;
    private final EventType eventType;
    private final String actionDescription;
}