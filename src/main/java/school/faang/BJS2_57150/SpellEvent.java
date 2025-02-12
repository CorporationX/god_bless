package school.faang.BJS2_57150;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
