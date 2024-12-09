package school.faang.sprint1.task_43888;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - getAgility());

        System.out.println(getName() + " attack " + character.getName() + " and hit " + getAgility() + " damage.");
        System.out.println(character.getName() + " has " + character.getHealth() + " health.");
    }
}
