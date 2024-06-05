package faang.school.godbless.absractionabstraction;

public class Archer extends Character{
    private static final int ARCHER_POWER = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLECT = 5;

    public Archer(String name) {
        super(name);
        this.power = ARCHER_POWER;
        this.agility = ARCHER_AGILITY;
        this.intellect = ARCHER_INTELLECT;
    }

    @Override
    public void attack(Character character) {
        character.getDamage(this.agility);
    }
}
