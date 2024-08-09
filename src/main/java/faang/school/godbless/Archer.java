package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - this.getAgility());
        System.out.println(this.getName() + " attacks " + enemy.getName() + " and deals " + this.getAgility() + " damage.");
    }

}

