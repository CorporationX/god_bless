package school.faang.catch_events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
