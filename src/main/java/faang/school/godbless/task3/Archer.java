package faang.school.godbless.task3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    public Archer(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.health - this.dexterity);
    }
}
