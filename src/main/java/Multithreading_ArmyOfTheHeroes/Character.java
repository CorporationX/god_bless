package Multithreading_ArmyOfTheHeroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Character {
    private int power;

    public boolean isArcher() {
        return false;
    }

    public boolean isMage() {
        return false;
    }

    public boolean isSwordsman() {
        return false;
    }
}
