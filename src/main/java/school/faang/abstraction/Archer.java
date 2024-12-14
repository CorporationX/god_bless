package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 5, 10);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " атакует,  " + target.getName() + "и наносит " + this.getStrength() + " урона");
        target.setHealth(target.getHealth()- this.getDexterity());
        System.out.println(target.getName() + " теперь имеет  " + target.getHealth() + " ловкости");

    }
}
