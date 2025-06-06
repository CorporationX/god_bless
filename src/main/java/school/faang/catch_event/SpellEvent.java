package school.faang.catch_event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    @Setter(AccessLevel.PRIVATE)
    private static int idCounter;
    private final int id;
    private String eventType;
    private String action;

    public SpellEvent() {
        this.id = ++idCounter;
    }

    public SpellEvent(String eventType, String action) {
        this.id = ++idCounter;
        this.eventType = eventType;
        this.action = action;
    }
}
