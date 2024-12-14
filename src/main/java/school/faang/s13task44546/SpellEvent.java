package school.faang.s13task44546;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class SpellEvent {
    private final int id;
    private final EventType eventType;
    private final String actionDescription;
}