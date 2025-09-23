package school.faang.m1.thread.army.units;

import lombok.AllArgsConstructor;
import school.faang.m1.thread.army.Unit;

@AllArgsConstructor
public class Mage implements Unit {

    private int power;

    public int getPower() {
        return power;
    }
}
