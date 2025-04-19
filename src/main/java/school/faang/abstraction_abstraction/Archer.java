package school.faang.abstraction_abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, CharacterConfig.ARCHER_STRENGTH,
                CharacterConfig.ARCHER_AGILITY, CharacterConfig.ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.updateHealth(getAgility());
    }
}