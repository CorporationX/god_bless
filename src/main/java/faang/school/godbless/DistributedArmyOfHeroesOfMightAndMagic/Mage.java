package faang.school.godbless.DistributedArmyOfHeroesOfMightAndMagic;

import lombok.Getter;

@Getter
public class Mage extends Units {
    private String type = "Mage";
    private int power;

    public Mage(int power) {
        this.power = power;
    }
}
