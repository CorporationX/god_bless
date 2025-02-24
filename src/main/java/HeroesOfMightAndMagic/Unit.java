package HeroesOfMightAndMagic;

import lombok.Getter;

@Getter
public class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }

}
