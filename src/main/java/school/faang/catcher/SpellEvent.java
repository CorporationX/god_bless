package school.faang.catcher;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
