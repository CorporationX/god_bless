package school.faang.bjs243845;

public class Warrior extends Character {

    private static final Integer FIXED_STRENGTH = 10;
    private static final Integer FIXED_AGILITY = 5;
    private static final Integer FIXED_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, FIXED_STRENGTH, FIXED_AGILITY, FIXED_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        Integer remainingHealth = character.getHealth() - getStrength();
        character.setHealth(remainingHealth);
    }

}
