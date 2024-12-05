package school.faang.sprint1.task_44545;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class SpellEvent {

    private long id;
    private String action;
    private String evenType;
}
