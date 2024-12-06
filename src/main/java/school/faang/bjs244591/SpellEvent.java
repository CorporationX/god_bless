package school.faang.bjs244591;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private SpellType eventType;
    private String action;
}
