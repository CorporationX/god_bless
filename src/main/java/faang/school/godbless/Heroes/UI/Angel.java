package faang.school.godbless.Heroes.UI;

public class Angel extends Creature {
    private static final int  ATTACK_CONST = 4;
    private static final int  PROTECTION_CONST = 6;
    private static final int  SPEED_CONST = 19;
    private static int count = 0;


    public int getCount(){
        return count;
    }

    public Angel(String name, int level) {
        super(name, level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST);
        count++;
    }


}
