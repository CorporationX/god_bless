package faang.school.godbless.task3;

public class Archer extends Character {
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}
