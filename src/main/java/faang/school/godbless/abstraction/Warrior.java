package faang.school.godbless.abstraction;

import lombok.ToString;

@ToString
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public String attack(Character character) {
        if (character.getHeath() <= 0) {
            return character + " died";
        }
        int remainHealth = character.getHeath() - strength;
        character.setHeath(remainHealth);
        return "health is left " + character.getHeath();
    }
}
