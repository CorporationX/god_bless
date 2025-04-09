package school.faang.bjs2_68670;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.NoSuchElementException;

@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    public static final String ID_IS_EMPTY = "Spell event id is empty;";
    public static final String EVENT_TYPE_IS_EMPTY = "Spell event type is empty;";
    public static final String ACTION_IS_EMPTY = "Spell action is empty;";

    private final Integer id;
    private final String eventType;
    private final String action;

    public SpellEvent(Integer id, String eventType, String action) {
        validateInputData(id, eventType, action);
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    private void validateInputData(Integer id, String eventType, String action) {
        StringBuilder error = new StringBuilder();
        if (id == null) {
            appendError(error, ID_IS_EMPTY);
        }
        if (eventType == null || eventType.isBlank()) {
            appendError(error, EVENT_TYPE_IS_EMPTY);
        }
        if (action == null || action.isBlank()) {
            appendError(error, ACTION_IS_EMPTY);
        }
        if (!error.isEmpty()) {
            throw new NoSuchElementException(error.toString());
        }
    }

    private void appendError(StringBuilder error, String errorMessage) {
        if (!error.isEmpty()) {
            error.append(" ");
        }
        error.append(errorMessage);
    }
}
