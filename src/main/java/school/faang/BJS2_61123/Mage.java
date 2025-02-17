package school.faang.BJS2_61123;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mage implements Fighter {

    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
