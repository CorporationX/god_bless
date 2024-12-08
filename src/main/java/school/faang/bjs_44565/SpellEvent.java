package school.faang.bjs_44565;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class SpellEvent {
    private final int id;
    private final EventType eventType;
    private final String actionDescription;

}
