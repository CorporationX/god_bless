package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int targetHealth = character.getHealth();
        int damage = getAgility();

        if (targetHealth <= 0) {
            System.out.println(character.getName() + " без сознания!");
        } else {
            character.setHealth(targetHealth - damage);
        }
    }
}
