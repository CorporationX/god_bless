package faang.school.godbless.bjs219140;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Griffin extends  Creature{
    public Griffin() {
        super("griffin", 1, 9, 4, 5);
    }
}
