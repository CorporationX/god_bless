package school.faang.bjs243856;

import lombok.NonNull;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(@NonNull Character character) {
        if(character.getHealth() - this.getDexterity() > 0) {
            character.setHealth(character.getHealth() - this.getDexterity());
        }else {
            character.setHealth(0);
        }
    }
}
