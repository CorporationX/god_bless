package school.faang.task_44464;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SpellEvent {
    private Integer id;
    private EventType eventType;
    private String action;
}
