package faang.school.godbless.BJS2_18615;

public class Archer extends Character{
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_DEXTERITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_DEXTERITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.dexterity;
    }
}
