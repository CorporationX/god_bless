package school.faang.bjs268712;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SpellEvent {
    private static int counter = 0;
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.id = ++counter;
        this.eventType = eventType;
        this.action = action;
    }
}
