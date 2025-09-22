package school.faang.bjs291341.warrior;

import lombok.Getter;

@Getter
public class Swordsman {
    private Integer power;
    private static final String description = "Мечники";

    public Swordsman(Integer power) {
        this.power = power;
    }
}
