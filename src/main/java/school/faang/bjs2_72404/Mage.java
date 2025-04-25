package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mage implements Hero {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}