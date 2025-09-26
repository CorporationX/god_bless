package school.faang.bjs291341.warrior;

import lombok.Getter;

@Getter
public class Swordsman extends Unit {

    private static final String description = "Мечники";

    public Swordsman(Integer power) {
        super(power);
    }
}
