package school.faang.army;

import lombok.Getter;

@Getter
public abstract class Unit implements Runnable {
    private int power;

    public Unit(int power) {
        this.power = power;
    }
}
