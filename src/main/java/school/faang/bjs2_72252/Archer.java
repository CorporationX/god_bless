package school.faang.bjs2_72252;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Archer extends UnitClass {
    public Archer() {
        this.power = 5;
    }
}
