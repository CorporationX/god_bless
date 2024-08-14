package faang.school.godbless.bjs219140;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Pikeman extends  Creature{
    public Pikeman() {
        super("pikeman", 1, 5, 5, 2);
    }
}
