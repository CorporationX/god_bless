package school.faang;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int damage = getStrength();
        target.setHealth(target.getHealth() - damage);
        System.out.println(getName() + " атакует " + target.getName() + " на " + damage + " урона!");
    }
}
