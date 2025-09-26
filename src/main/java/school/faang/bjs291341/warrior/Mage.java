package school.faang.bjs291341.warrior;

import lombok.Getter;

@Getter
public class Mage extends Unit {

    private static final String description = "Маги";

    public Mage(Integer power) {
        super(power);
    }
}
