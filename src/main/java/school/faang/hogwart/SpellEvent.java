package school.faang.hogwart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

}