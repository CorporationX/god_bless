package faang.school.godbless.BJS2_511.creatures;

public class Griffin extends Creature {
    public static final String GRIFFIN_DEFAULT_NAME = "Griffin";
    public static final int GRIFFIN_DEFAULT_LEVEL = 20;
    public static final int GRIFFIN_DEFAULT_ATTACK = 20;
    public static final int GRIFFIN_DEFAULT_DEFENSE = 20;
    public static final int GRIFFIN_DEFAULT_SPEED = 20;

    public Griffin(int quantity) {
        super(GRIFFIN_DEFAULT_NAME, GRIFFIN_DEFAULT_LEVEL, GRIFFIN_DEFAULT_ATTACK, GRIFFIN_DEFAULT_DEFENSE, GRIFFIN_DEFAULT_SPEED, quantity);
    }

    public Griffin(int quantity, String name) {
        super(name, GRIFFIN_DEFAULT_LEVEL, GRIFFIN_DEFAULT_ATTACK, GRIFFIN_DEFAULT_DEFENSE, GRIFFIN_DEFAULT_SPEED, quantity);
    }
}
