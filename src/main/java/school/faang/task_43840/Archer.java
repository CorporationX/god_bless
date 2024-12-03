package school.faang.task_43840;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intellect = 5;
    }

    @Override
    public void attack(Character character) {
        health -= character.agility;
    }
}
