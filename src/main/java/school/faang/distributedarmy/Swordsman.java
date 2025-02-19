package school.faang.distributedarmy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Swordsman implements Unit {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
