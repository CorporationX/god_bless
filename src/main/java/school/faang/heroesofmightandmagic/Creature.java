package school.faang.heroesofmightandmagic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    // Abstract method to calculate damage dealt by the creature
    public abstract int getDamage();
}