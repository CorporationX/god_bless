package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import lombok.Getter;

@Getter
public class Swordsman extends Units {
    private String type = "Swordsman";
    private int power;

    public Swordsman(int power) {
        this.power = power;
    }
}
