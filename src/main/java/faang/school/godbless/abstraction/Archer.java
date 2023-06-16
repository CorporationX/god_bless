package faang.school.godbless.abstraction;

import lombok.ToString;

@ToString
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public String attack(Character character) {
        if (character.getHeath() <= 0) {
            return character + " died";
        }
        int remainHealth = character.getHeath() - agility;
        character.setHeath(remainHealth);
        return "health is left " + character.getHeath();
    }


}
