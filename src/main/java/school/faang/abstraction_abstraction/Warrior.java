package school.faang.abstraction_abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, CharacterConfig.WARRIOR_STRENGTH,
                CharacterConfig.WARRIOR_AGILITY, CharacterConfig.WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.updateHealth(getStrength());
    }
}