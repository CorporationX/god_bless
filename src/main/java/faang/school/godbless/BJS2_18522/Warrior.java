package faang.school.godbless.BJS2_18522;

import lombok.Data;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(int strength, int dexterity, int intelligence) {
        super(10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }
}
