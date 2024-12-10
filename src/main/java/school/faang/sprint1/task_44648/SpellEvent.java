package school.faang.sprint1.task_44648;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@ToString
public class SpellEvent {
    public static final String CHARM_TYPE = "Charm";
    public static final String TRANSFIGURATION_TYPE = "Transfiguration";
    public static final String PROTECTION_TYPE = "Protection";
    public static final Set<String> EVENT_TYPES = Set.of(CHARM_TYPE, TRANSFIGURATION_TYPE, PROTECTION_TYPE);
    private final int id;
    @NonNull
    private final String eventType;
    @NonNull
    private final String action;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return Objects.equals(eventType, that.eventType) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, action);
    }
}
