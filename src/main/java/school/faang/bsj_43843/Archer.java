package school.faang.bsj_43843;

public class Archer extends Character {
    public Archer(String name) {
        super(name, DefaultsParameters.ARCHER_STRENGTH, DefaultsParameters.ARCHER_AGILITY,
                DefaultsParameters.ARCHER_INTELLIGENCE);
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
