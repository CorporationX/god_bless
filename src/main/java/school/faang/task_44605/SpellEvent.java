package school.faang.task_44605;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class SpellEvent {
    private final int id;
    @NonNull
    private final Type eventType;

    @Override
    public String toString() {
        return "SpellEvent{id=" + id + ", eventType=" + eventType + ", description=" + eventType.getDescription() + '}';
    }
}
