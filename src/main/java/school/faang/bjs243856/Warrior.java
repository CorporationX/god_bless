package school.faang.bjs243856;

import lombok.NonNull;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(@NonNull Character character) {
        if (character.getHealth() - this.getPower() > 0) {
            character.setHealth(character.getHealth() - this.getPower());
        } else {
            character.setHealth(0);
        }
    }
}
