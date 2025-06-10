package school.faang.bjs279721;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SpellEvent {
    private long id;
    private String eventType;
    private String action;
}
