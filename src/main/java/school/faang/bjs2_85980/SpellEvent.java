package school.faang.bjs2_85980;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class SpellEvent {
    @EqualsAndHashCode.Include
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = Objects.requireNonNull(eventType, "Event type cannot be null");
        this.action = Objects.requireNonNull(action, "Action cannot be null");
    }
}