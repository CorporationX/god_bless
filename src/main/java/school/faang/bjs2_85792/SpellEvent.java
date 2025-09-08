package school.faang.bjs2_85792;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private final int id;
    private final EventType eventType;
    private final String action;
}
