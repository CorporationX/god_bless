package faang.school.godbless.Heroes.UI;


public class Swordman extends Creature {
    private static final int ATTACK_CONST = 9;
    private static final int PROTECTION_CONST = 12;
    private static final int SPEED_CONST = 8;



    public Swordman(int level, int count) {
        super("Swordman lvl" + level, level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST, count);
    }

    @Override
    public int summaryPower() {
        return level * ( damage + protection / 3 + speed * 2);
    }
}
