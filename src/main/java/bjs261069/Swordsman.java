package bjs261069;

import lombok.Getter;

@Getter
public class Swordsman extends Fighter {
    private final int power;

    public Swordsman(int power) {
        super();
        this.power = power != 0 ? power : 40;
    }
}
