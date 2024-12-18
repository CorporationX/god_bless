package character;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    public void attack(Character target) {
        target.reduceHealth(this.strength);
        System.out.println(target.getName() + " attack " + target.getName() + " and applies "
                + this.strength + " damage.");
    }
}
