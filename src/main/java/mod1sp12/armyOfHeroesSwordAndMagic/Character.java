package mod1sp12.armyOfHeroesSwordAndMagic;

import lombok.Data;

@Data
public abstract class Character {
    public int power;

    public Character(int power) {
        this.power = power;
    }
}
