package school.faang.bjs291341.warrior;

import lombok.Getter;

@Getter
public class Archer extends Unit {

    private static final String description = "Лучники";

    public Archer(Integer power) {
        super(power);
    }
}
