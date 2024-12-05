package school.faang.task_bjs43864;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Archer extends Character {
    private String name;

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - getDexterity());
    }
}
