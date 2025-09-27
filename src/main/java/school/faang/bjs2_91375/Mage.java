package school.faang.bjs2_91375;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Mage implements Warrior {
    private final int power;

    @Override
    public int getPower() {
        return power;
    }
}
