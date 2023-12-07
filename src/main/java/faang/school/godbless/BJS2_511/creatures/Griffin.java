package faang.school.godbless.BJS2_511.creatures;



public class Griffin extends Creature{
    public static final String GRIFFIN_DEFAULT_NAME = "Griffin";
    public static final int GRIFFIN_DEFAULT_LEVEL = 2;
    public static final int GRIFFIN_DEFAULT_DAMAGE = 2;
    public static final int GRIFFIN_DEFAULT_DEFENSE = 2;
    public static final int GRIFFIN_DEFAULT_SPEED = 2;
    public static final int GRIFFIN_DEFAULT_QUANTITY = 1;
    public Griffin(int quantity) {
        super(GRIFFIN_DEFAULT_NAME, GRIFFIN_DEFAULT_LEVEL, GRIFFIN_DEFAULT_DAMAGE, GRIFFIN_DEFAULT_DEFENSE, GRIFFIN_DEFAULT_SPEED
                , quantity);
    }
}
