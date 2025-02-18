package school.faang.distributedarmy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mage implements Unit {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}