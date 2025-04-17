package school.faang.cathingspells;

import lombok.Data;

@Data
public class SpellEvent {
    private final Integer id;
    private final String eventType;
    private final String action;
}
