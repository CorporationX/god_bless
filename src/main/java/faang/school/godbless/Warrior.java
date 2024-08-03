package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int targetHealth = character.getHealth();
        int damage = getStrength();

        if (targetHealth <= 0) {
            System.out.println(character.getName() + " без сознания!");
        } else {
            character.setHealth(targetHealth - damage);
        }
    }


}
