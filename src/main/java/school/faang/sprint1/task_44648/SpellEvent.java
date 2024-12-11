package school.faang.sprint1.task_44648;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    public enum EventTypes {
        CHARM,
        TRANSFIGURATION,
        PROTECTION;
    }

    @EqualsAndHashCode.Exclude
    private final int id;
    @NonNull
    private final EventTypes eventType;
    @NonNull
    private final String description;
}
