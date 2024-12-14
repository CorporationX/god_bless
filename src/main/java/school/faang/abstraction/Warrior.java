package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " атакует, " + target.getName() + " и наносит " + this.getStrength() + "урона");
        target.setHealth((target.getHealth()-this.getStrength()));
        System.out.println(target.getName() + " теперь имеет: " + target.getHealth() + " здоровья");

    }
}
