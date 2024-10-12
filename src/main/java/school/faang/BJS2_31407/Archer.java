package school.faang.BJS2_31407;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        int health = enemy.getHealth()- this.getAgility();

        enemy.setHealth(Math.max(health, 0));

        System.out.println(this.getName() + " attacks " + enemy.getName() + " and deals " + this.getAgility() + " damage.");
    }

}

