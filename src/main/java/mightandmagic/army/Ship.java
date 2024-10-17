package mightandmagic.army;

import lombok.Getter;

@Getter
public abstract class Ship {
    private final int power;

    public Ship(int power) {
        if (power <= 0) {
            throw new IllegalArgumentException("Добавьте мощи космическому кораблю!");
        }
        this.power = power;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (мощь: " + power + ")";
    }
}
