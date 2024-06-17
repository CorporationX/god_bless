package faang.school.godbless.DistributedArmyHeroes;

import lombok.Getter;

@Getter
public abstract class Character {
    private int power;

    public Character(int power) {
        this.power = power;
    }
}
