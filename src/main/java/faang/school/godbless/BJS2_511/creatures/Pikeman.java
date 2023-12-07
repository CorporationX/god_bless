package faang.school.godbless.BJS2_511.creatures;

public class Pikeman extends Creature {
    public static final String PIKEMAN_DEFAULT_NAME = "Pikeman";
    public static final int PIKEMAN_DEFAULT_LEVEL = 3;
    public static final int PIKEMAN_DEFAULT_DAMAGE = 3;
    public static final int PIKEMAN_DEFAULT_DEFENSE = 3;
    public static final int PIKEMAN_DEFAULT_SPEED = 3;
    public static final int PIKEMAN_DEFAULT_QUANTITY = 1;
    public Pikeman(int quantity) {
        super(PIKEMAN_DEFAULT_NAME, PIKEMAN_DEFAULT_LEVEL,PIKEMAN_DEFAULT_DAMAGE,PIKEMAN_DEFAULT_DEFENSE,PIKEMAN_DEFAULT_SPEED
                , quantity);
    }
}
