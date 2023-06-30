package Multithreading.bc2157;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Hero {
    private int power;

    public boolean isArcher() {
        return false;
    }

    public boolean isSwordsman() {
        return false;
    }

    public boolean isMage() {
        return false;
    }


}
