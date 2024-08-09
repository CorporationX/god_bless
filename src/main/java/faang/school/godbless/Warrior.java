package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.getHealth() - this.getPower());
        System.out.println(this.getName() + " attacks " + enemy.getName() + " and deals " + this.getPower() + " damage.");
    }

}
