package catching.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private Integer id;
    private String eventType;
    private String action;
}
