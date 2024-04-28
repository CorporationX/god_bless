package faang.school.godbless.armyOfHeroesOfMightAndMagic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private int power;
    private int amount;

    public int getSquadPower() {
        return power*amount;
    }
}

