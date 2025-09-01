package school.faang.spells;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpellEvent {
    private Integer id;
    private String eventType;
    private String action;
}
