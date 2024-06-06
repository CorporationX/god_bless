package faang.school.godbless;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);

        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    @Override
    void attack(Character character) {
        character.setHealth(Math.max(character.getHealth() - this.getAgility(), 0));
    }
}
