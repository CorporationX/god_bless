package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Swordsman implements Hero {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}