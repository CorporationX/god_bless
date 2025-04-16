package school.faang.catchevents;

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
    private String magicSpell;
    private String spellDescription;
}
