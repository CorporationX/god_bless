package school.faang.task_48486;

import lombok.Getter;

@Getter
public abstract class Character {
    protected final int power;

    public Character(int power) {
        this.power = power;
    }
}
