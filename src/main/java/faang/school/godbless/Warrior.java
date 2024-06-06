package faang.school.godbless;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);

        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    @Override
    void attack(Character character) {
        character.setHealth(Math.max(character.getHealth() - this.getStrength(), 0));
    }
}
