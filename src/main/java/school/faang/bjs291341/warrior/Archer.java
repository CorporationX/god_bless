package school.faang.bjs291341.warrior;

import lombok.Getter;

@Getter
public class Archer {
    private Integer power;
    private static final String description = "Лучники";

    public Archer(Integer i) {
        this.power = i;
    }
}
