package school.faang.distributedarmy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Archer implements Unit {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
