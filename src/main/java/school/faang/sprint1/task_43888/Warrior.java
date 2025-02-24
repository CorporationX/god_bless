package school.faang.sprint1.task_43888;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }


    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - getPower());

        System.out.println(getName() + " attack " + character.getName() + " and hit " + getPower() + " damage.");
        System.out.println(character.getName() + " has " + character.getHealth() + " health.");
    }
}
