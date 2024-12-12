package school.faang.sprint1.task_bjs244634;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
