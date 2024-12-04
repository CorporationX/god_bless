package school.faang.bjs243845;

public class Archer extends Character {

    private static final Integer FIXED_STRENGTH = 3;
    private static final Integer FIXED_AGILITY = 10;
    private static final Integer FIXED_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, FIXED_STRENGTH, FIXED_AGILITY, FIXED_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        Integer remainingHealth = character.getHealth() - getStrength();
        character.setHealth(remainingHealth);
    }

}
