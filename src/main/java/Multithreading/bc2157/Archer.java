package Multithreading.bc2157;

import lombok.Getter;

@Getter
public class Archer extends Hero {

    public Archer(int power) {
        super(power);
    }

    public boolean isArcher() {
        return true;
    }
}
