package school.faang.m1.thread.army.units;

import lombok.AllArgsConstructor;
import school.faang.m1.thread.army.Unit;

@AllArgsConstructor
public class Swordsman implements Unit {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
