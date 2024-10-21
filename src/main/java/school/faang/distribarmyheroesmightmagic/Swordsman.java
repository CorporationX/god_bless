package school.faang.distribarmyheroesmightmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Swordsman implements Unit {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
