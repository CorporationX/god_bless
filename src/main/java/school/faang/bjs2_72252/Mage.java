package school.faang.bjs2_72252;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Mage extends UnitClass {
    public Mage() {
        this.power = 2;
    }
}
