package faang.school.godbless.distributed_army;

import lombok.Getter;

@Getter
public abstract class Character {
    private final int power;

    public Character(int power) {
        this.power = power;
    }
}
