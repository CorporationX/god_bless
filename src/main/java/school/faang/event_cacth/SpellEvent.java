package school.faang.event_cacth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
