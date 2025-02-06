package school.faang.task_57076;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
