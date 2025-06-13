package school.faang.bjs279758;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
