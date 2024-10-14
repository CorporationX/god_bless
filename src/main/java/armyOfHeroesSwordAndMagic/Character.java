package armyOfHeroesSwordAndMagic;

import lombok.Data;

@Data
public abstract class Character {
    protected int power;

    protected Character(int power) {
        this.power = power;
    }
}
