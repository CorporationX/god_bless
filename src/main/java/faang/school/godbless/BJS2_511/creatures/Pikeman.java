package faang.school.godbless.BJS2_511.creatures;

public class Pikeman extends Creature {
    public static final String PIKEMAN_DEFAULT_NAME = "Pikeman";
    public static final int PIKEMAN_DEFAULT_LEVEL = 30;
    public static final int PIKEMAN_DEFAULT_ATTACK = 30;
    public static final int PIKEMAN_DEFAULT_DEFENSE = 30;
    public static final int PIKEMAN_DEFAULT_SPEED = 30;

    public Pikeman(int quantity) {
        super(PIKEMAN_DEFAULT_NAME, PIKEMAN_DEFAULT_LEVEL, PIKEMAN_DEFAULT_ATTACK, PIKEMAN_DEFAULT_DEFENSE, PIKEMAN_DEFAULT_SPEED, quantity);
    }

    public Pikeman(int quantity, String name) {
        super(name, PIKEMAN_DEFAULT_LEVEL, PIKEMAN_DEFAULT_ATTACK,PIKEMAN_DEFAULT_DEFENSE,PIKEMAN_DEFAULT_SPEED, quantity);
    }
}
