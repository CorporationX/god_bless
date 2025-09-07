package school.faang.BJS2_85936;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = true)
@EqualsAndHashCode
@AllArgsConstructor
public class SpellEvent {
    private final int id;
    @Getter
    private final String eventType;
    private final String action;
}
