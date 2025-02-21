package school.faang.armyheroes;

import lombok.Getter;

@Getter
public class Archer extends Heroes {
    private static final int POWER = 25;


    public Archer(String name) {
        super(name, POWER);
    }
}
