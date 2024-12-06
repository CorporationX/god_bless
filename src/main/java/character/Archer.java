package character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character target) {
        target.reduceHealth(this.agility);
        System.out.println(target.getName() + " attack " + target.getName() + " and applies "
                + this.agility + " damage. ");
    }
}
