package school.faang.bjs2_91397;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Swordsman implements Fighter {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
