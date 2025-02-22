package school.faang.bjs2_61228;

import lombok.Getter;

@Getter
public abstract class Character {

    protected int power;

    protected Character(int power) {
        this.power = power;
    }
}
