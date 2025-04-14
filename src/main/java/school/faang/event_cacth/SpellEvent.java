package school.faang.event_cacth;

import lombok.Data;
import lombok.NonNull;

@NonNull
@Data
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
