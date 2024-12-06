package school.faang.bsj_43843;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, DefaultsParameters.WARRIOR_STRENGTH, DefaultsParameters.WARRIOR_AGILITY,
                DefaultsParameters.WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character != null) {
            character.setHealth(character.getHealth() - strength);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
