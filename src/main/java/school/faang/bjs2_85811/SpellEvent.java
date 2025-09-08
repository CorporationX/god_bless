package school.faang.bjs2_85811;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
public class SpellEvent {
    @Setter(AccessLevel.NONE)
    private static int idCounter = 1;
    private final Integer id;
    private final String eventType;
    private final String action;

    public SpellEvent(String eventType, String action) {
        this.id = idCounter++;
        this.eventType = eventType;
        this.action = action;
    }

    Integer uniqueId() {
        return id;
    }
}
