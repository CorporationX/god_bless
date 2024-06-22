package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import lombok.Getter;

@Getter
public class Archer extends Units {
    private String type = "Archer";
    private int power;

    public Archer(int power) {
        this.power = power;
    }
}