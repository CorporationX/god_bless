package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Swordsman implements Warrior {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}