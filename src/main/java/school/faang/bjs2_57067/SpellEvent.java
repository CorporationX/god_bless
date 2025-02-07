package school.faang.bjs2_57067;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class SpellEvent {

    private final int id;
    private final String eventType;
    private final String action;
    private static int currentId = 1;

    public SpellEvent(String eventType, String action) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не может быть пустым или null");
        }
        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Действие заклинания не может быть пустым или null");
        }

        this.id = currentId++;
        this.eventType = eventType;
        this.action = action;
    }
}
