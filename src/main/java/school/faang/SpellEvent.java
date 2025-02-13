package school.faang;

import lombok.Data;

@Data
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}
