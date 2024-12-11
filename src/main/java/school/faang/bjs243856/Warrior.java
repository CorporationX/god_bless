package school.faang.bjs243856;

import lombok.NonNull;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(@NonNull Character character) {
        character.setHealth(Math.max(character.getHealth() - this.getPower(), 0));
    }
}
