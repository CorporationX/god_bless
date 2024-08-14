package faang.school.godbless.dolbahlop;

public class Griffin extends Creature {
    private static final String NAME = "Griffin";
    private static final int LEVEL = 20;
    private static final int ATTACK = 80;
    private static final int DEFENSE = 80;
    private static final int SPEED = 70;

    public Griffin(int quantity){
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }
}
