package faang.school.godbless.Heroes.UI;

public class Pikeman extends Creature {
    private static final int ATTACK_CONST = 9;
    private static final int PROTECTION_CONST = 15;
    private static final int SPEED_CONST = 5;
    private static int count = 0;


    public int getCount(){
        return count;
    }

    public Pikeman(String name, int level) {
        super(name, level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST);
        count++;
    }


}
