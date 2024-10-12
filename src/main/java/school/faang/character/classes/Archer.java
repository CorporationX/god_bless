package school.faang.character.classes;

import java.util.Calendar;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        int damage = getDexterity();
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println(getName() + " наносит " + enemy.getName() + " " + damage + " урона");
    }
}
