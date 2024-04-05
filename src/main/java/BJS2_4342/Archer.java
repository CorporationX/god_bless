package BJS2_4342;

import lombok.ToString;

@ToString
public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealthPoint(character.getHealthPoint() - this.getStrength());
    }
}
