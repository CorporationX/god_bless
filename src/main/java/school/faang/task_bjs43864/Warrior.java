package school.faang.task_bjs43864;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {
    private String name;

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - getPower());
    }
}
