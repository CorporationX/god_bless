package Multithreading.bc2157;

import lombok.Getter;

@Getter
public class Swordsman extends Hero {

    public Swordsman(int power) {
        super(power);
    }

    public boolean isSwordsman() {
        return true;
    }
}
