package school.faang.catchingevents;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
