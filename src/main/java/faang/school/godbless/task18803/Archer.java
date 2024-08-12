package faang.school.godbless.task18803;

public class Archer extends Character{
    public static final int POWER = 3;
    public static final int DEXTERITY = 10;
    public static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
        this.power = POWER;
        this.dexterity = DEXTERITY;
        this.intelligence = INTELLIGENCE;
    }

    @Override
    public void attack(Character defending) {
        defending.health -= DEXTERITY;
    }
}
