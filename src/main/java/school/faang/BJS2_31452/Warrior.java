package school.faang.BJS2_31452;

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
        int health = enemy.getHealth() - this.getPower();

        enemy.setHealth(Math.max(health, 0));

        enemy.setHealth(enemy.getHealth() - this.getPower());
        System.out.println(this.getName() + " attacks " + enemy.getName() + " and deals " + this.getPower() + " damage.");
    }

}
