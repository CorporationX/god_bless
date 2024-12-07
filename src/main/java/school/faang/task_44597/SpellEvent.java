package school.faang.task_44597;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
