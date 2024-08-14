package faang.school.godbless.bjs219140;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Angel extends Creature {
    public Angel() {
        super("angel", 1, 8, 4, 5);
    }
}
