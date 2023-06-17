package faang.school.godbless.abstraction;

import lombok.ToString;

@ToString
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public String attack(Character character) {
        int remainHealth = character.getHeath() - agility;

        if (remainHealth < 0) {
            character.setHeath(0);
            return character + " died";
        }
        if (remainHealth > 0) {
            character.setHeath(remainHealth);
            return "health is left " + character.getHeath();
        }
        return "";
    }


}
