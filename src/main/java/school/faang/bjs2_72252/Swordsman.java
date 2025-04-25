package school.faang.bjs2_72252;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Swordsman extends UnitClass {
    public Swordsman() {
        this.power = 10;
    }
}