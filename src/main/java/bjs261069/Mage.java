package bjs261069;

import lombok.Getter;

@Getter
public class Mage extends Fighter {
    private final int power;

    public Mage(int power) {
        super();
        this.power = power != 0 ? power : 50;
    }
}
