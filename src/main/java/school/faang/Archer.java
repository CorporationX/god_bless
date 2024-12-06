package school.faang;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int damage = getAgility();
        target.setHealth(target.getHealth() - damage);
        System.out.println(getName() + " атакует " + target.getName() + " на " + damage + " урона!");
    }
}
