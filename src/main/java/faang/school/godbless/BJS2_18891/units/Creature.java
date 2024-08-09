package faang.school.godbless.BJS2_18891.units;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public abstract class Creature {
    private String name;
    private Integer level;
    private Integer attack;
    private Integer defense;
    private Integer speed;
    private Integer health;
}
