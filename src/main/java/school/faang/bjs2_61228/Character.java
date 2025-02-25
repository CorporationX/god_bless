package school.faang.bjs2_61228;

import lombok.Getter;

@Getter
public abstract class Character {

    protected int power;

    protected Character(int power) {
        valid(power);
        this.power = power;
    }

    protected abstract void attack();

    private void valid(int power) {
        if (power <= 0) {
            throw new IllegalArgumentException("Сила должна быть больше нуля!!!");
        }
    }

}
