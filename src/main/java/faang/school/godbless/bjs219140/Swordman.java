package faang.school.godbless.bjs219140;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Swordman extends Creature{
    public Swordman() {
        super("swordman", 1, 4, 4, 5);
    }
}
