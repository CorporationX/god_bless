package faang.school.godbless.task18803;

public class Warrior extends Character {

    public static final int POWER = 10;
    public static final int DEXTERITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        this.power = POWER;
        this.dexterity = DEXTERITY;
        this.intelligence = INTELLIGENCE;
    }

    @Override
    public void attack(Character defending) {
        defending.health -= POWER;
    }
}
