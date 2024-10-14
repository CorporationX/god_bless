package school.faang.armyofheros;

import lombok.Data;

@Data
public abstract class Character {
    private int power;

    protected Character(int power) {
        this.power = power;
    }
}
