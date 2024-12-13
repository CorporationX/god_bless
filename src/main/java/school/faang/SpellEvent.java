package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

}
