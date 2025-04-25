package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Archer implements Hero {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
